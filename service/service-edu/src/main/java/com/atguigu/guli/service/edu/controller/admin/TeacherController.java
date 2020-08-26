package com.atguigu.guli.service.edu.controller.admin;


import com.atguigu.guli.service.base.result.R;
import com.atguigu.guli.service.edu.entity.Teacher;
import com.atguigu.guli.service.edu.entity.query.TeacherQuery;
import com.atguigu.guli.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author Helen
 * @since 2020-08-25
 */
@Api(tags = "讲师管理")
@RestController
@RequestMapping("/admin/edu/teacher")
@CrossOrigin //跨域注解
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("获取所有讲师列表")
    @GetMapping("list")
    public R list(){
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据id删除讲师", notes = "逻辑删除")
    @DeleteMapping("remove/{id}")
    public R removeById(
            @ApiParam(value = "讲师id", required = true) @PathVariable String id){
        boolean b = teacherService.removeById(id);
        if(b){
            return R.ok().message("删除成功");
        }else{
            return R.error().message("数据不存在");
        }
    }

    @ApiOperation("分页查询讲师列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(
            @ApiParam(value = "当前页码", required = true) @PathVariable Long page,
            @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit,
            @ApiParam(value = "讲师列表查询对象", required = false)TeacherQuery teacherQuery){

//        Page<Teacher> pageParam = new Page<>(page, limit);
//        teacherService.page(pageParam);
        IPage<Teacher> teacherModel = teacherService.selectPage(page, limit, teacherQuery);
        return R.ok().data("pageModel", teacherModel);
    }

    @ApiOperation("新增讲师")
    @PostMapping("save")
    public R save(
            @ApiParam(value = "讲师列对象", required = true)
            @RequestBody Teacher teacher){
        boolean b = teacherService.save(teacher);
        if(b){
            return R.ok().message("添加成功");
        }else{
            return R.error().message("添加失败");
        }
    }

    @ApiOperation("更新讲师")
    @PutMapping("update")
    public R update(
            @ApiParam(value = "讲师列对象", required = true)
            @RequestBody Teacher teacher){ //teacher对象中需要包含id
        boolean b = teacherService.updateById(teacher);
        if(b){
            return R.ok().message("更新成功");
        }else{
            return R.error().message("更新失败");
        }
    }

    @ApiOperation("根据id查询讲师")
    @GetMapping("get/{id}")
    public R getById(
            @ApiParam(value = "讲师id", required = true) @PathVariable String id){
        Teacher teacher = teacherService.getById(id);
        if(teacher != null){
            return R.ok().data("item", teacher);
        }else{
            return R.error().message("数据不存在");
        }
    }
}



