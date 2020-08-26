package com.atguigu.guli.service.edu.controller.api;


import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "讲师管理")
@RestController
@RequestMapping("/api/edu/teacher/")
public class ApiTeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("获取所有讲师列表")
    @GetMapping("list")
    public List<Teacher> list() {
        return teacherService.list();
    }
}
