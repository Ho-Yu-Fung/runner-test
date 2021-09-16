package com.example.runnertest.mapper;

import com.example.runnertest.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {
    @Insert("insert into user(name,pwd,salt) values(#{name},#{pwd},#{salt})")
    void save(User user);

    @Select("select * from user where name = #{name}")
    User findUserByName(String name);


}
