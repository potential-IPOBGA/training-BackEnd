package com.example.demo.repository;

import com.example.demo.beans.Trainer;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository {

    @Select("select id,name from trainer where groupid = #{groupid}")
    @ResultType(Trainer.class)
    List<Trainer> getTrainersByGroup(Long groupid);



}
