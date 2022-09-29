package com.example.aop_pj.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;

//@Configuration
public class MyDataSourceConfig implements WebMvcConfigurer {


//    @Bean
//    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
        //同时开启 sql 监控(stat) 和防火墙(wall)，中间用逗号隔开。
        //开启防火墙能够防御 SQL 注入攻击
//        druidDataSource.setFilters("stat,wall");


        return  druidDataSource;
    }


    //配置前端页面
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        StatViewServlet statViewServlet = new StatViewServlet();
//        //向容器中注入 StatViewServlet，并将其路径映射设置为 /druid/*
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(statViewServlet, "/druid/*");
//        //配置监控页面访问的账号和密码（选配）
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        return servletRegistrationBean;
//    }




}
