package com.example.marketconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Place {
    private String place_name; // name of place
    private String formatted_address;
    private String place_id;
    private double lat;
    private double lng;
    private List<String> types;
}
