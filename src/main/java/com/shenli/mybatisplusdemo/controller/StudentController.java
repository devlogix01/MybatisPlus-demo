package com.shenli.mybatisplusdemo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shenli.mybatisplusdemo.common.AjaxResult;
import com.shenli.mybatisplusdemo.entity.Student;
import com.shenli.mybatisplusdemo.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*
* 控制器
* */
@RestController //@ResposeBody + @Controller 以json字符串格式返回给前端
@RequestMapping("student") //建立映射关系
public class StudentController {

    @Resource
    private StudentService studentService;

    /*
    * 查询所有
    * */
    @GetMapping("findAll")
    public AjaxResult findAll(){
        List<Student> studentList = studentService.list();
        return AjaxResult.success(studentList);
    }

    /*
    * 通过id查询
    * */
    @GetMapping("findById/{id}")
    public AjaxResult findById(@PathVariable Integer Id){
        Student student = studentService.getById(Id);
        return AjaxResult.success(student);
    }

    /*
    * 新增
    * */
    @PostMapping("add")
    public AjaxResult add(@RequestBody Student student){
        boolean save = studentService.save(student);
        return AjaxResult.success(save);
    }

    /*
    * 修改
    * */
    @PutMapping("edit")
    public AjaxResult edit(@RequestBody Student student){
        boolean update = studentService.updateById(student);
        return AjaxResult.success(update);
    }

    /*
    * 删除
    * */
    @DeleteMapping("remove/{Id}")
    public AjaxResult remove(@PathVariable Integer Id){
        boolean remove = studentService.removeById(Id);
        return AjaxResult.success(remove);
    }

    /*
    * 批量删除
    * */
    @DeleteMapping("batchRemove/{Ids}")
    public AjaxResult batchRemove(@PathVariable List<Integer> ids){
        boolean batchRemove = studentService.removeByIds(ids);
        return AjaxResult.success(batchRemove);
    }

    /*分页条件查询
    * */
    @GetMapping("/findByPage")
    public AjaxResult findByPage(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "1") String name,
            @RequestParam(defaultValue = "1") String birthplace,
            @RequestParam(defaultValue = "1") String major
    ){
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("Id");
        if (!"".equals(name)){
            queryWrapper.like("name",name);
        }
        if (!"".equals(birthplace)){
            queryWrapper.like("birthplace",birthplace);
        }
        if (!"".equals(major)){
            queryWrapper.like("major",major);
        }
        return AjaxResult.success(studentService.page(new Page<>(pageNum,pageSize),queryWrapper));
    }
}
