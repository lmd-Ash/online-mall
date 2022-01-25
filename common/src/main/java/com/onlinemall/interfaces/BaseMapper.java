package com.onlinemall.interfaces;

import com.onlinemall.tkmybatis.BaseEntity;
import com.onlinemall.utils.PersistUtils;
import org.springframework.data.repository.NoRepositoryBean;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

import java.util.List;

@NoRepositoryBean
public interface BaseMapper<T extends BaseEntity> extends Mapper<T>, IdsMapper<T>, MySqlMapper<T> {
    //TODO
    //FIXME 特别注意，该接口不能被扫描到，否则会出错

    default T save(T t) {
        return PersistUtils.save(this, t);
    }

    default int updateList(List<T> recordList) {
        return PersistUtils.updateList(this, recordList);
    }

    default List<T> saveAll(List<T> recordList) {
        return PersistUtils.saveAll(this, recordList);
    }

    default int deleteByIds(List ids) {
        return PersistUtils.deleteByIds(this, ids);
    }

    default List<T> selectByIds(List ids) {
        return PersistUtils.selectByIds(this, ids);
    }
}
