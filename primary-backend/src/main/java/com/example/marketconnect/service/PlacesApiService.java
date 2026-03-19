package com.example.marketconnect.service;

import com.example.marketconnect.dto.Place;
import com.example.marketconnect.dto.PlacesResponse;
import com.example.marketconnect.dto.SearchRequestBody;
import com.example.marketconnect.dto.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Map;

@Component
public class PlacesApiService {

    @Autowired
    private RestClient restClient;

    @Value("${api.google.places.base-url}")
    private String url;

    @Value("${api.google.api-key}")
    private String apiKey;

    public Map<String, Object> buildRequestBody(SearchRequestBody params, Place place){
        Map<String, Object> requestBody = Map.of(
                "maxResultCount", 5,
                "includedTypes" , params.getIncludedTypes(),
                "excludedTypes", params.getExcludedTypes(),
                "locationRestriction", Map.of(
                        "circle", Map.of(
                                "center", Map.of(
                                        "latitude", place.getLat(),
                                        "longitude", place.getLng()
                                ),
                                "radius", 500.0
                        )
                )
        );

        return requestBody;
    }

    public List<Shop> getShopsList(SearchRequestBody params, Place place){
        PlacesResponse response = restClient.post()
                .uri(url)
                .header("Content-Type", "application/json")
                .header("X-Goog-Api-Key", apiKey)
                .header("X-Goog-FieldMask",
                        "places.displayName,places.types,places.formattedAddress," +
                                "places.websiteUri,places.businessStatus,places.openingDate," +
                                "places.internationalPhoneNumber,places.nationalPhoneNumber")
                .body(buildRequestBody(params, place))
                .retrieve()
                .body(PlacesResponse.class);

        return response != null ? response.getPlaces() : List.of();
    }
}
