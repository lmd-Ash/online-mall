package com.onlinemall.server;

/**
 * redis服务
 *
 * @author lmd
 * @version 1.0
 */
public interface RedisService {
    /**
     * 保存 键-值到Redis
     *
     * @param key   键
     * @param value 值
     */
    public void set(String key, Object value);

    /**
     * 保存 键-值到Redis
     *
     * @param key     键
     * @param value   值
     * @param timeout 失效时间(秒)
     */
    public void setExpire(String key, Object value, long timeout);

    /**
     * 延长key失效时间
     *
     * @param key     键
     * @param timeout 失效时间(秒)
     */
    public void setExpire(String key, long timeout);

    /**
     * 删除
     *
     * @param key 键
     */
    public void remove(String key);


    /**
     * 获取唯一Id
     *
     * @return 返回得到的Id
     */
    public long getGlobalId();

    /**
     * 根据key查询数据
     *
     * @param key    键
     * @param aClass 泛型
     * @return 返回对象
     */
    public <T> T get(String key, Class<T> aClass);

    /**
     * 获得订单编号 编号规则yyyyMMdd+每天的订单数量
     *
     * @return 返回商品编号
     */
    String getOrderNo();

    /**
     * redis中原子递增
     *
     * @param key key
     * @param num 步长
     * @return 返回自增后的值
     */
    Long increment(String key, Integer num);

    /**
     * redis中原子递减
     *
     * @param key key
     * @param num 步长
     * @return 返回递减后的值
     */
    Long decrement(String key, Integer num);


    /**
     * 添加进集合
     *
     * @param key key
     * @param obj 值
     */
    Long addSet(String key, Object obj);

    /**
     * 根据key查询数据
     *
     * @param key    键
     * @param aClass 泛型
     * @return 返回对象
     */
    <T> T getSet(String key, Class<T> aClass);


    /**
     * 获取key剩余时间
     *
     * @param key 键
     */
    Long getExpire(String key);

    /**
     * 根据key前缀批量删除数据
     *
     * @param pre 前缀
     */
    public void deleteByPre(String pre);

}
