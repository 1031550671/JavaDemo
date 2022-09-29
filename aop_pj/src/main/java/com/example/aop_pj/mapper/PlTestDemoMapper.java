package com.example.aop_pj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.aop_pj.domain.PlTestDemo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface PlTestDemoMapper extends BaseMapper<PlTestDemo> {


    @Select("select * from pl_test_demo")
    List<PlTestDemo> selectbyList();

}
