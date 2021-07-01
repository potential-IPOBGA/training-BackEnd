package com.example.demo.repository;

import com.example.demo.beans.Trainee;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository {
    @Select("select id,name from trainee where groupid = #{groupid}")
    @ResultType(Trainee.class)
    List<Trainee> getTraineesByGroup(Long groupid);
}
