package com.shenli.mybatisplusdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shenli.mybatisplusdemo.entity.Student;

public interface StudentMapper extends BaseMapper<Student> {
    /*
    * 数据访问层: StudentMapper接口,继承BaseMapper接口
    * Mybatis-Plus中基本增删改查都在内置的BaseMappper,通过继承可以直接调用
    * */
}
