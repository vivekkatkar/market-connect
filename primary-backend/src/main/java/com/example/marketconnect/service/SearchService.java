package com.example.marketconnect.service;

import com.example.marketconnect.dto.Place;
import com.example.marketconnect.dto.SearchRequestBody;
import com.example.marketconnect.dto.Shop;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private PlacesApiService placesApiService;
    private KafkaProducerService kafkaProducerService;
    private LocationService locationService;

    SearchService(PlacesApiService placesApiService, KafkaProducerService kafkaProducerService, LocationService locationService){
        this.placesApiService = placesApiService;
        this.kafkaProducerService = kafkaProducerService;
        this.locationService = locationService;
    }

    public List<Shop> searchShopsNearTo(SearchRequestBody params){
        String address = params.getPlace();
        Place result = locationService.getPlaceLocation(address);

        System.out.println(result);

        List<Shop> response = placesApiService.getShopsList(params, result);
//
//        // TODO : save all shops details into db
//
//        // TODO : * push all shops to kafka queue
//        response.getShopsList().forEach((shop) -> {
//            kafkaProducerService.sendMessage(KafkaConstant.KAFKA_TOPIC, shop);
//        });

        return response;
    }
}
