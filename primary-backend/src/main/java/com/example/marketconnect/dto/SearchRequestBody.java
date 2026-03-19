package com.example.marketconnect.dto;

import java.util.List;

public class SearchRequestBody {
    List<String> includedTypes;
    List<String> excludedTypes;
    Long radius;
}
