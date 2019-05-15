package com.yj.service.impl;

import com.yj.dao.IBaseMapper;
import com.yj.dao.ITeacherMapper;
import com.yj.entity.Teacher;
import com.yj.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 29029
 * @Version 1.0
 * @User 29029
 * @Time 19:24
 */
@Service
public class TeacherServiceImpl extends BaseServiceImpl<Teacher> implements ITeacherService {

    @Autowired
    private ITeacherMapper teacherMapper;

    @Override
    protected IBaseMapper<Teacher> getBaseDao() {
        return teacherMapper;
    }

    @Override
    public List<Teacher> getTeaAll() {
        return teacherMapper.getTeaAll();
    }
}
