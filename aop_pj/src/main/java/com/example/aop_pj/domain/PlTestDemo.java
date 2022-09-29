package com.example.aop_pj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.example.aop_pj.unit.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("pl_test_demo")
public class PlTestDemo extends BaseEntity {


//    private String id;
    @TableField("notice_type")
    private String noticeType;
    @TableField("languge_type")
    private String langugeType;
    @TableField("content")
    private String content;



}
