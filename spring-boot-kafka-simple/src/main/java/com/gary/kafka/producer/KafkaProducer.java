package com.gary.kafka.producer;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void sendMessage(String topic, String content) {
        kafkaTemplate.send(topic,"helloKey", content);

//        ProducerRecord record = new ProducerRecord<String, String>
//                ("my-topic", null, System.currentTimeMillis(), "key", "value");
//        kafkaTemplate.send(record);
    }

}

