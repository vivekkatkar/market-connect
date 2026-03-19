package com.example.marketconnect.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Place {
    String place_name; // name of place
    String formatted_address;
    String place_id;
    Long lat;
    Long lng;
}
