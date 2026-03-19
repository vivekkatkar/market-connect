package com.example.marketconnect.dto;

import lombok.Data;

import java.util.List;

@Data
public class SearchRequestBody {
    private String place;
    private List<String> includedTypes;
    private List<String> excludedTypes;
    private Long radius;
}
