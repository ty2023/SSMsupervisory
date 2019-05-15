package com.yj.service;

import com.github.pagehelper.PageInfo;
import com.yj.entity.Page;

/**
 * @author 29029
 */
public interface IBaseService<T> {

    /**
     * 查询并分页
     * @param page
     * @param t
     * @return
     */
    PageInfo<T> getPage(Page<T> page, T t);

    /**
     * 公共删除
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
     * 修改某条信息
     * @param t
     */
    Integer doUpdate(T t);
}
