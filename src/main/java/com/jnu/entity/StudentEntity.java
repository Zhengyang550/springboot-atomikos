package com.jnu.entity;

import lombok.Data;

/**
 * @Author: zy
 * @Description: student实体类
 * @Date: 2020-2-4
 */
@Data
public class StudentEntity {
    /**
     * id 主键、自增
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private Boolean sex;

    /**
     * 班级
     */
    private String className;

    /**
     * 地址
     */
    private String address;

}
