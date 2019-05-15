package com.yj.service;

import com.yj.entity.Teacher;

import java.util.List;

/**
 * @author 29029
 */
public interface ITeacherService extends IBaseService<Teacher> {
    /**
     * 查询所有老师
     * @return
     */
    List<Teacher> getTeaAll();
}
