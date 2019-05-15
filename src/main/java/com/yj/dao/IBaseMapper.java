package com.yj.dao;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @User 29029
 * @Time 19:52
 */
public interface IBaseMapper<T> {

    /**
     * 查询所有
     * @param t
     * @return
     */
    List<T> getList(T t);

    /**
     * 删除对象
     * @param id
     * @return
     */
    Integer doDelete(Integer id);

    /**
     * 查询单个信息
     * @param id
     * @return
     */
    T getById(Integer id);

    /**
     * 修改某个信息
     * @param t
     * @return
     */
    Integer doUpdate(T t);
}
