package com.yj.controller;

import com.yj.entity.Student;
import com.yj.entity.Teacher;
import com.yj.service.IBaseService;
import com.yj.service.IStudentService;
import com.yj.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 29029
 * @Version 1.0
 * @User 29029
 * @Time 19:21
 */
@Controller
@RequestMapping("stuController")
public class StudentController extends BaseController<Student>{

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ITeacherService teacherService;

    @Override
    protected IBaseService<Student> getBaseService() {
        return studentService;
    }

    @RequestMapping("/getByStuId/{id}")
    public String getAllTea(@PathVariable Integer id,ModelMap map){
        Student student = studentService.getById(id);
        List<Teacher> teaAll = teacherService.getTeaAll();
        map.put("stu",student);
        map.put("teacher",teaAll);
        return "student/student_Update";
    }

}
