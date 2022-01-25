package com.onlinemall.server.impl;

import com.onlinemall.server.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * RedisServices实现
 *
 * @author lmd
 * @version 1.0
 */
@Service
@Slf4j
public class RedisServiceImpl implements RedisService {
    @Value("${default.redis.key}")
    String defaultPrefix;
    @Value("${pk.id.redis.key.prefix}")
    String pkIdPrefix;
    @Value("${order.no.redis.key.prefix}")
    String orderNoPrefix;
    @Value("${order.no.redis.value.prefix:}")
    String orderNoValuePrefix;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(defaultPrefix + key, value);
    }

    @Override
    public void setExpire(String key, Object value, long timeout) {
        redisTemplate.opsForValue().set(defaultPrefix + key, value, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void setExpire(String key, long timeout) {
        redisTemplate.expire(defaultPrefix + key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(defaultPrefix + key);
    }


    @Override
    public long getGlobalId() {
        // 每天重新开始增长
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String dateString = dateFormat.format(new Date());
        Long increment = redisTemplate.opsForValue().increment(pkIdPrefix + dateString, 1);
        // 两天后过期
        redisTemplate.expire(pkIdPrefix + dateString, 2, TimeUnit.DAYS);
        long id = Long.parseLong(dateString + increment);
        log.debug("redis中Id自增序号为：[{}]", id);
        return id;
    }

    @Override
    public <T> T get(String key, Class<T> aClass) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        Object value = redisTemplate.opsForValue().get(defaultPrefix + key);
        return Objects.isNull(value) ? null : aClass.cast(value);
    }

    @Override
    public String getOrderNo() {
        Random random = new Random();
        int nextInt1 = random.nextInt(9);
        int nextInt2 = random.nextInt(9);
        int nextInt3 = random.nextInt(9);
        // 订单后缀为3位随机数
        return orderNoValuePrefix + getNo(orderNoPrefix) + nextInt1 + nextInt2 + nextInt3;
    }

    @Override
    public Long increment(String key, Integer num) {
        Long increment = redisTemplate.opsForValue().increment(defaultPrefix + key, num);
        log.info("key为:[{}]，在redis中自增值为:[{}]", key, increment);
        return increment;
    }

    @Override
    public Long decrement(String key, Integer num) {
        Long decrement = redisTemplate.opsForValue().decrement(defaultPrefix + key, num);
        log.info("key为:[{}]，在redis中递减值为:[{}]", key, decrement);
        return decrement;
    }

    @Override
    public Long addSet(String key, Object obj) {
        return redisTemplate.opsForSet().add(defaultPrefix + key, obj);
    }

    @Override
    public <T> T getSet(String key, Class<T> aClass) {
        return aClass.cast(redisTemplate.opsForSet().members(defaultPrefix + key));
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(defaultPrefix + key);
    }

    @Override
    public void deleteByPre(String pre) {
        Set<String> keys = redisTemplate.keys(defaultPrefix + pre + "*");
        if (CollectionUtils.isNotEmpty(keys)) {
            redisTemplate.delete(keys);
        }
    }

    private String getNo(String productNoPrefix) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
        String dateString = dateFormat.format(new Date());
        Long increment = redisTemplate.opsForValue().increment(productNoPrefix + dateString, 1);
        // 两天后过期
        redisTemplate.expire(productNoPrefix + dateString, 2, TimeUnit.DAYS);
        DecimalFormat df = new DecimalFormat("00000");
        return dateString + df.format(increment);
    }
}
