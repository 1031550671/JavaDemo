package com.example.aop_pj.executor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 多线程类
 */
@Component
@Slf4j
public class taskTest02 {

    @Async("taskExecutor")
    public void test02(){
        try {
            Thread.sleep(5000);
            log.info("线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
