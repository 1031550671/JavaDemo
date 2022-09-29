package com.example.aop_pj.test;


import lombok.extern.slf4j.Slf4j;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j@Component
public class PostConstructExampleBean {

    private static final Logger LOG
            = Logger.getLogger(PostConstructExampleBean.class);

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        //environment 已经注入
        log.info("PostConstruct 注入");
        LOG.info(Arrays.asList(environment.getDefaultProfiles()));
    }





}
