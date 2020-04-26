package com.cht.kafka.config;

import com.cht.kafka.websocket.WebSocketServer;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {
    /**
     * 从分组为test中topic的test中取数据
     * @param record
     */
    @KafkaListener(topics = {"test"},groupId = "test")
    public void receiveRemoteControlResult(ConsumerRecord<String,byte[]> record){
        String s = new String(record.value());
        Gson gson = new Gson();
        String str = gson.fromJson(s, String.class);
        System.out.println(str);
        WebSocketServer.sendInfo(str);
    }
}