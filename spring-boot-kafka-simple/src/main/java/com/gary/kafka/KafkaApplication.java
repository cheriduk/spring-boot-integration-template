package com.gary.kafka;

import com.gary.kafka.cases.KafKaCustomrProducer;
import com.gary.kafka.muilti.MutilSendMsgController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = MutilSendMsgController.class)
public class KafkaApplication {
    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class,args);
    }
}
