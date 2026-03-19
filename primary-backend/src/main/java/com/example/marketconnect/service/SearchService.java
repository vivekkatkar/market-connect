package com.example.marketconnect.service;

import com.example.marketconnect.constants.KafkaConstant;
import com.example.marketconnect.dto.PlacesApiResponseEntity;
import com.example.marketconnect.utils.PlacesAPI;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    private PlacesAPI placesAPI;
    private KafkaProducerService kafkaProducerService;

    SearchService(PlacesAPI placesAPI, KafkaProducerService kafkaProducerService){
        this.placesAPI = placesAPI;
        this.kafkaProducerService = kafkaProducerService;
    }

    public String searchShopsNearTo(String place){

        PlacesApiResponseEntity response = placesAPI.getShopsList(place);

        // TODO : save all shops details into db

        // TODO : * push all shops to kafka queue
        response.getShopsList().forEach((shop) -> {
            kafkaProducerService.sendMessage(KafkaConstant.KAFKA_TOPIC, shop);
        });

        return "Finding Shops near to " + place;
    }
}
