package com.config;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MySchedulee {
    @Scheduled(fixedDelay = 1000)
    public void fixedDelay(){
        System.out.println("fixedDelay:"+new Date());
    }

    @Scheduled(fixedRate = 2000)
    public void fixedRate(){
        System.out.println("fixedRate:"+new Date());
    }

    @Scheduled(initialDelay = 1000,fixedRate = 2000)
    public void initialDalay(){
        System.out.println("initialDalay:"+new Date());
    }
    @Scheduled(cron = "0 * * * * ?")
    public void cron(){
        System.out.println("cron:"+new Date());
    }
}
