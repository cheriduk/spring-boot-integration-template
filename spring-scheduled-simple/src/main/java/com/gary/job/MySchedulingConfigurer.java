package com.gary.job;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
@Order(value = 11)
@Configuration
@EnableScheduling
public class MySchedulingConfigurer implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addFixedRateTask(() -> System.out.println("执行定时[任务1]: " + new Date()), 1000);
        TriggerTask triggerTask = new TriggerTask( // 任务内容.拉姆达表达式
                () -> {
                    System.out.println("执行定时[任务2]: " + new Date());
                },
                // 设置触发器，这里是一个拉姆达表达式，传入的TriggerContext类型，返回的是Date类型
                triggerContext -> {
                    // 2.3 返回执行周期(Date)
                    return new CronTrigger("*/2 * * * * ?").nextExecutionTime(triggerContext);
                });

        taskRegistrar.addTriggerTask(triggerTask);
    }

}
