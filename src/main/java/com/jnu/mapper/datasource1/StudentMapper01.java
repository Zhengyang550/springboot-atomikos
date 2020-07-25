package com.jnu.mapper.datasource1;

import com.jnu.entity.StudentEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

/**
 * @Author: zy
 * @Description: student Mapper类
 * @Date: 2020-2-4
 */
@Service
public interface StudentMapper01 {
    //查询语句
    @Select("SELECT id,name,age,sex,`class` as className,address FROM STUDENT1 WHERE ID = #{id}")
    StudentEntity getStudentById(@Param("id") Integer id);

    //新增语句
    @Insert("INSERT INTO STUDENT1(name,age,sex) VALUES(#{name}, #{age},#{sex})")
    int insertStudent(@Param("name") String name, @Param("age") Integer age,@Param("sex") Boolean sex);
}
