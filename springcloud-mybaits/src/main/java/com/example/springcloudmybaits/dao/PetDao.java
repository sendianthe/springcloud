package com.example.springcloudmybaits.dao;

import com.example.springcloudmybaits.dao.Pet;
import com.example.springcloudmybaits.dao.PetExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PetDao {
    long countByExample(PetExample example);

    int deleteByExample(PetExample example);

    int insert(Pet record);

    int insertSelective(Pet record);

    List<Pet> selectByExample(PetExample example);

    int updateByExampleSelective(@Param("record") Pet record, @Param("example") PetExample example);

    int updateByExample(@Param("record") Pet record, @Param("example") PetExample example);


}