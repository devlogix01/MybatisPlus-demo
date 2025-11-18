package com.shenli.mybatisplusdemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shenli.mybatisplusdemo.entity.Student;
import com.shenli.mybatisplusdemo.mapper.StudentMapper;
import com.shenli.mybatisplusdemo.service.StudentService;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

}
