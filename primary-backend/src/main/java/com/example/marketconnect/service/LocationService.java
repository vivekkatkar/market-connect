package com.example.marketconnect.service;

import com.example.marketconnect.dto.Place;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class LocationService {
    private RestClient locationServiceClient;

    public Place getPlaceLocation(String place){
        Long lat = 0L;
        Long lng = 0L;

        return new Place();
    }
}
