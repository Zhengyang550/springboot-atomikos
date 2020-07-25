package com.jnu.datasource;

import com.jnu.service.datasource1.StudentService01;
import com.jnu.service.datasource2.StudentService02;
import com.jnu.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zy
 * @Description: 多数据源控制器
 * @Date: 2020-2-5
 */
@RestController
public class MyBatisMultilDataSourceController {
    @Autowired
    private StudentService01 studentService01;

    /**
     * 新增学生 这里没有对参数进行校验  127.0.0.1:8080/insertStudent01?name=01&age=25&sex=1
     * @param name：姓名
     * @param age：年龄
     * @param sex：性别
     * @return：返回受影响的行数
     */
    @RequestMapping("/insertStudent01")
    public int insertStudent01(@RequestParam String name, @RequestParam Integer age, @RequestParam Boolean sex){
        return studentService01.insertStudent(name,age,sex);
    }

    /**
     * 根据id获取学生信息
     * @param id：学生id
     * @return：返回学生信息
     */
    @RequestMapping("/getStudent01")
    public StudentEntity getStudentById01(@RequestParam Integer id){
        return studentService01.getStudentById(id);
    }

    @Autowired
    private StudentService02 studentService02;

    /**
     * 新增学生 这里没有对参数进行校验  127.0.0.1:8080/insertStudent02?name=02&age=25&sex=1
     * @param name：姓名
     * @param age：年龄
     * @param sex：性别
     * @return：返回受影响的行数
     */
    @RequestMapping("/insertStudent02")
    public int insertStudent02(@RequestParam String name, @RequestParam Integer age, @RequestParam Boolean sex){
        return studentService02.insertStudent(name,age,sex);
    }

    /**
     * 根据id获取学生信息
     * @param id：学生id
     * @return：返回学生信息
     */
    @RequestMapping("/getStudent02")
    public StudentEntity getStudentById02(@RequestParam Integer id){
        return studentService02.getStudentById(id);
    }


    /**
     * 新增学生 这里没有对参数进行校验  127.0.0.1:8080/insertStudent?name=00&age=25&sex=1
     * @param name：姓名
     * @param age：年龄
     * @param sex：性别
     * @return：返回受影响的行数
     */
    @RequestMapping("/insertStudent")
    @Transactional
    public int insertStudent01AndStudent02(@RequestParam String name, @RequestParam Integer age, @RequestParam Boolean sex){
        //第一个数据源
        int ret1 = studentService01.insertStudent(name,age,sex);
        //第二个数据源
        int ret2 = studentService02.insertStudent(name,age,sex);
        int i=1/age;
        //要不全部插入 要不全部不插入
        return ret1+ret2;
    }
}
