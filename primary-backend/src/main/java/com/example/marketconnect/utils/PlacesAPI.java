package com.example.marketconnect.utils;

import com.example.marketconnect.dto.Place;
import com.example.marketconnect.dto.PlacesApiResponseEntity;
import com.example.marketconnect.dto.Shop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class PlacesAPI {
    @Qualifier("placesApiWebClient")
    private WebClient placesApiWebClient;

    public PlacesApiResponseEntity getShopsList(String place){

        // TODO : Verify request params and response
        List<Shop> result = placesApiWebClient.get()
                .uri("/place/" + place)
                .retrieve()
                .bodyToFlux(Shop.class)
                .collectList()
                .block();

        return new PlacesApiResponseEntity(place, result);
    }
}
