package com.example.demo.repository;

import com.example.demo.beans.Trainee;
import com.example.demo.beans.Trainer;
import com.example.demo.response.TraineeResponse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository {
    @Select("select id,name from trainee where groupid = #{groupid}")
    @ResultType(TraineeResponse.class)
    List<TraineeResponse> getTraineesByGroup(Long groupid);


    @Insert("insert into Trainee (name,groupId) VALUES (#{name},0)")
    @Options(useGeneratedKeys = true)
    Long saveTrainee(String name);

    @Select("select id,name from Trainee where id = #{id}")
    @ResultType(Trainee.class)
    Trainer findTraineeById(Long id);

    @Delete("delete from Trainee where id = #{id}")
    void deleteTrainee(Long id);

}
