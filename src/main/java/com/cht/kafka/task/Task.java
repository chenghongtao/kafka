package com.cht.kafka.task;

import com.cht.kafka.config.KafkaProducter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configuration
@EnableScheduling
public class Task {

    @Autowired
    private KafkaProducter producter;

    @Scheduled(fixedRate = 5000)
    public void testTask(){
        String str=String.valueOf(System.currentTimeMillis());
        producter.sendDataToKafka("test",str);

    }
}
