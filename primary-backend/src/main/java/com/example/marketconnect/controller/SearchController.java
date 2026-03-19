package com.example.marketconnect.controller;

import com.example.marketconnect.dto.SearchRequestBody;
import com.example.marketconnect.dto.Shop;
import com.example.marketconnect.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService searchService;

    SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping("/search")
    public List<Shop> search(@RequestBody SearchRequestBody requestBody){

        return searchService.searchShopsNearTo(requestBody);
    }
}
