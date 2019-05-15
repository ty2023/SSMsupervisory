package com.yj.dao;

import com.yj.entity.Teacher;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @User 29029
 * @Time 19:29
 */
public interface ITeacherMapper extends IBaseMapper<Teacher> {

    /**
     * 查询所有老师
     * @return
     */
    List<Teacher> getTeaAll();
}
