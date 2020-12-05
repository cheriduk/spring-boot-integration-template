package com.gary;

import com.gary.job.MySchedulingConfigurer;
import com.gary.multithread.MultiThreadScheduleTask;
import com.gary.schedules.DynamicScheduleTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackageClasses = MySchedulingConfigurer.class)
public class ScheduledApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScheduledApplication.class, args);
    }
}
