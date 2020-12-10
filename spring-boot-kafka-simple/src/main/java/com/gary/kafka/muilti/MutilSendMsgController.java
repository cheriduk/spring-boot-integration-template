package com.gary.kafka.muilti;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MutilSendMsgController {
    @Autowired
    KafkaTemplate kafkaTemplate;

    /***
     * 多消费者组、组中多消费者对同一主题的消费情况
     */
    @GetMapping("sendGroup")
    public void sendGroup() {
        for (int i = 0; i < 4; i++) {
            // 第二个参数指定分区，第三个参数指定消息键 分区优先
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send("Topic.GROUP", i % 4, "key", "hello group " + i);
            future.addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.info("发送消息失败:" + throwable.getMessage());
                }

                @Override
                public void onSuccess(SendResult<String, Object> sendResult) {
                    System.out.println("发送结果:" + sendResult.toString());
                }
            });
        }
    }
}

