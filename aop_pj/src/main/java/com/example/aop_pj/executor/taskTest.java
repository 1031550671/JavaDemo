package com.example.aop_pj.executor;

import com.google.common.util.concurrent.Runnables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;


@Slf4j
public class taskTest implements Runnable {


    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            log.info("睡醒啦");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
