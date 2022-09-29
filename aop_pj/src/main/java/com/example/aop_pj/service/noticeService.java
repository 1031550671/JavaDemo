package com.example.aop_pj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.example.aop_pj.config.ThreadPoolTaskConfig;
import com.example.aop_pj.domain.Dto.getDTO;
import com.example.aop_pj.domain.PlTestDemo;
import com.example.aop_pj.executor.taskTest;
import com.example.aop_pj.executor.taskTest02;
import com.example.aop_pj.mapper.PlTestDemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class noticeService {


    @Resource
    PlTestDemoMapper PlTestDemoMapper;

    @Resource
    ThreadPoolTaskConfig threadPoolTaskConfig;

    @Resource
    taskTest02 taskTest02;


    public PlTestDemo getOne()
    {
        List<PlTestDemo> res = PlTestDemoMapper.selectbyList();
        QueryWrapper<PlTestDemo> queryWrapper = new QueryWrapper<>();
        List<PlTestDemo> res2 = PlTestDemoMapper.selectList(queryWrapper);
        taskTest02.test02();
//        threadPoolTaskConfig.getAsyncExecutor().execute(new taskTest());
        return res.get(0);
    }

    public PlTestDemo getSome(getDTO getDTO)
    {
        System.out.println(String.format("輸出：-------------------------" + getDTO.getName()));



        return PlTestDemoMapper.selectById(getDTO.getId());
    }
}
