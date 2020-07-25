package com.jnu.service.datasource1;

import com.jnu.mapper.datasource1.StudentMapper01;
import com.jnu.entity.StudentEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: zy
 * @Description: student业务逻辑
 * @Date: 2020-2-4
 */
@Service
@Slf4j
public class StudentService01 {
    @Autowired
    private StudentMapper01 studentMapper01;

    /**
     * 新增学生
     * @param name：姓名
     * @param age：年龄
     * @param sex：性别
     * @return：返回受影响的行数
     */
    public int insertStudent(String name,Integer age,Boolean sex){
        int ret = studentMapper01.insertStudent(name,age,sex);
        log.info("#####新增学生###########",ret);
        return ret;
    }


    /**
     * 根据id获取学生信息
     * @param id：学生id
     * @return：返回学生信息
     */
    public StudentEntity  getStudentById(Integer id){
        log.info("#####获取学生信息###########",id);
        return studentMapper01.getStudentById(id);
    }
}
