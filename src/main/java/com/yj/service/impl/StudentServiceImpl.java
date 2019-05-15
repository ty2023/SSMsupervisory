package com.yj.service.impl;

import com.yj.dao.IBaseMapper;
import com.yj.dao.IStudentMapper;
import com.yj.entity.Student;
import com.yj.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 29029
 * @Version 1.0
 * @User 29029
 * @Time 19:24
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<Student> implements IStudentService  {

    @Autowired
    private IStudentMapper studentMapper;

    @Override
    protected IBaseMapper<Student> getBaseDao() {
        return studentMapper;
    }


}
