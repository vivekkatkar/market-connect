package com.example.marketconnect.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PlacesApiResponseEntity {
    private String centralPlace;
    private List<Shop> shopsList;
}
