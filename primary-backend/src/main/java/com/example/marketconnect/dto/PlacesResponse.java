package com.example.marketconnect.dto;

import lombok.Data;

import java.util.List;

@Data
public class PlacesResponse {
    private List<Shop> places;
}
