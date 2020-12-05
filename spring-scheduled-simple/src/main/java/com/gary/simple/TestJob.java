package com.gary.simple;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;

/**
 * 使用注解
 * // https://cron.qqe2.com/ 在线cron表达式生成器
 */
//@Component
@EnableScheduling//可以在启动类上注解也可以在当前文件
public class TestJob {

    /**
     * 10秒一次
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void runfirst() {
        System.out.println("********【first job】 is ok******" + new Date());
    }

    /**
     * 间隔10秒一次
     */
    @Scheduled(fixedRate = 1000 * 10)
    public void runsecend() {
        System.out.println("********《second job》 is ok******" + new Date());
    }

    /**
     * 1秒一次
     */
    @Scheduled(fixedDelay = 1000)
    public void runThird() {
        System.out.println("********third job is ok*******" + new Date());
    }
}
