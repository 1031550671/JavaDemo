package com.example.aop_pj.controller;

import com.example.aop_pj.annotation.Permissions;
import com.example.aop_pj.domain.Dto.getDTO;
import com.example.aop_pj.service.noticeService;
import com.example.aop_pj.unit.ResultUnit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Api(tags = "play")
@RestController
@RequestMapping("/test")
public class noticeController {

    @Resource
    noticeService noticeService;

    @Autowired
    DataSource dataSource;

//    @Autowired
//    JdbcTemplate jdbcTemplate;


//    @ApiOperation(value = "測試")
//    @GetMapping("/hello")
//    public String hello() throws SQLException
//    {
//        System.out.println("默认数据源为：" + dataSource.getClass());
//        System.out.println("数据库连接实例：" + dataSource.getConnection());
//        //访问数据库
//        Integer i = jdbcTemplate.queryForObject("SELECT count(*) from pl_test_demo", Integer.class);
//        System.out.println("user 表中共有" + i + "条数据。");
//        return "成功";
//    }

    @ApiOperation(value = "獲取")
    @GetMapping("/getOne")
    public ResponseEntity getOne()
    {
        return ResultUnit.success(noticeService.getOne());
    }



//    @Permissions
//    @GetMapping("get")
//    public ResponseEntity get(@RequestParam(required = true) String id,
//                                @RequestParam String name){
//        return ResultUnit.success(noticeService.getSome(id,name));
//    }

    @Permissions
    @PostMapping("/get")
    public ResponseEntity get(@RequestBody getDTO getDTO){
        return ResultUnit.success(noticeService.getSome(getDTO));
    }


}
