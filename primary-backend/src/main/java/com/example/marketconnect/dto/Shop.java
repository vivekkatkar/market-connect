package com.example.marketconnect.dto;

import lombok.Data;

import java.util.List;

@Data
public class Shop {
    DisplayName displayName;
    String businessStatus;
    String formattedAddress;
    String internationalPhoneNumber;
    String nationalPhoneNumber;
    List<String> types;
    String websiteUri;
}
