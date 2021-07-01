package com.example.demo.repository;

import com.example.demo.beans.Trainer;
import com.example.demo.response.TrainerResponse;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository {

    @Select("select id,name from trainer where groupid = #{groupid}")
    @ResultType(TrainerResponse.class)
    List<TrainerResponse> getTrainersByGroup(Long groupid);

    @Insert("insert into trainer (name) VALUES (#{name})")
    Long saveTrainer(String name);

    @Select("select id,name from trainer where id = #{id}")
    @ResultType(Trainer.class)
    Trainer findTrainerById(Long id);

    @Delete("delete from trainer where id = #{id}")
    void deleteTrainer(Long id);

}
