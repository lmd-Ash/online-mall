package com.onlinemall.utils;

import com.google.common.collect.Lists;
import com.onlinemall.exception.CustomException;
import com.onlinemall.interfaces.BaseMapper;
import com.onlinemall.tkmybatis.BaseEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @description 持久化工具类
 */
public class PersistUtils {

    /**
     * 保存
     *
     * @param mapper
     * @param t
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> T save(BaseMapper<T> mapper, T t) {
        if (t != null) {
            if (t.getId() == null) {
                mapper.insertSelective(t);
            } else {
                if (mapper.existsWithPrimaryKey(t.getId())) {
                    mapper.updateByPrimaryKeySelective(t);
                } else {
//                    t.setId(null);
//                    mapper.insertSelective(t);
                    throw new CustomException("数据主键不存在！");
                }
            }
            return mapper.selectByPrimaryKey(t.getId());
        }
        return null;
    }

    /**
     * 批量更新
     *
     * @param mapper
     * @param recordList
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> int updateList(BaseMapper<T> mapper, List<T> recordList) {
        if (recordList != null && recordList.size() > 0) {
            return recordList.stream().map(record -> mapper.updateByPrimaryKeySelective(record)).mapToInt(Integer::intValue).sum();
        }
        return 0;
    }

    /**
     * 批量保存
     *
     * @param mapper
     * @param recordList
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> List<T> saveAll(BaseMapper<T> mapper, List<T> recordList) {
        if (recordList != null && recordList.size() > 0) {
            return recordList.stream().map(record -> save(mapper, record)).filter(Objects::nonNull).collect(Collectors.toList());
        }
        return Lists.newArrayList();
    }

    /**
     * 根据主键集合进行删除
     *
     * @param mapper
     * @param ids
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> int deleteByIds(BaseMapper<T> mapper, List<Number> ids) {
        if (ids != null && ids.size() > 0) {
            return mapper.deleteByIds(ids.stream().map(id -> String.valueOf(id)).collect(Collectors.joining(",")));
        }
        return 0;
    }

    /**
     * 根据主键集合查询
     *
     * @param mapper
     * @param ids
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> List<T> selectByIds(BaseMapper<T> mapper, List<Number> ids) {
        if (ids != null && ids.size() > 0) {
            return mapper.selectByIds(ids.stream().map(id -> String.valueOf(id)).collect(Collectors.joining(",")));
        }
        return Lists.newArrayList();
    }
}
