package com.example.marketconnect.service;

import com.example.marketconnect.dto.Shop;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, Shop> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, Shop> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Shop shop){
        kafkaTemplate.send(topic, shop);
    }
}
