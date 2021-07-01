package com.example.demo.repository;

import com.example.demo.beans.Group;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupRepository {
    @Select("select id,name from group")
    @ResultType(Group.class)
    List<Group> getAllGroup();

}
