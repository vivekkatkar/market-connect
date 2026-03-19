package com.example.marketconnect.dto.geocode;

import lombok.Data;

import java.util.List;

@Data
public class GeocodeResponse {
    private List<Result> results;
    private String status;
}

