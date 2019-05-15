package com.yj.controller;

import com.yj.entity.Teacher;
import com.yj.service.IBaseService;
import com.yj.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 29029
 * @Version 1.0
 * @User 29029
 * @Time 19:21
 */
@Controller
@RequestMapping("teaController")
public class TeacherController extends BaseController<Teacher> {

    @Autowired
    private ITeacherService teacherService;


    @Override
    protected IBaseService<Teacher> getBaseService() {
        return teacherService;
    }


}
