package com.shenli.mybatisplusdemo.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/*
* Student实体类
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_student") //指定映射的表名
public class Student {

    //主键id
    private Integer Id;
    private String name;
    private String sex;
    @JsonFormat(pattern = "yyyy-MM-DD")
    private String birthday;
    private String birthplace;
    private String major;
    private String mobile;
    private String email;
    private String idNumber;

}
