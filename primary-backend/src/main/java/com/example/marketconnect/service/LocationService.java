package com.example.marketconnect.service;

import com.example.marketconnect.dto.Place;
import com.example.marketconnect.dto.geocode.GeocodeResponse;
import com.example.marketconnect.dto.geocode.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class LocationService {
@Autowired
    private RestClient restClient;

    @Value("${api.google.geocoding.base-url}")
    private String url;

    @Value("${api.google.apikey}")
    private String apikey;

    public Place getPlaceLocation(String place){
        GeocodeResponse response = restClient.get()
                .uri(url + "?address=" + place + "&key=" + apikey)
                .retrieve()
                .body(GeocodeResponse.class);

        System.out.println(response);

        if (response != null && !response.getResults().isEmpty()) {
            Location location = response.getResults().get(0).getGeometry().getLocation();
            String formated_address = response.getResults().get(0).getFormatted_address();
            String place_id = response.getResults().get(0).getPlace_id();
            List<String> types = response.getResults().get(0).getTypes();

            double lat = location.getLat();
            double lng = location.getLng();

            System.out.println(formated_address);
            System.out.println(place_id);
            System.out.println(types);
            System.out.println(lat);
            System.out.println(lng);

            return new Place(place, formated_address, place_id, lat, lng, types);
        }

        return new Place();
    }
}
