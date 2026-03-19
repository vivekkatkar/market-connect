package com.example.marketconnect.dto.geocode;

import lombok.Data;

import java.util.List;


@Data
public class Result {
    private Geometry geometry;
    private String place_id;
    private String formatted_address;
    private List<String> types;
}