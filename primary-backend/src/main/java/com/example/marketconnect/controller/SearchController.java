package com.example.marketconnect.controller;

import com.example.marketconnect.dto.SearchRequestBody;
import com.example.marketconnect.service.SearchService;
import org.springframework.web.bind.annotation.*;

@RestController
public class SearchController {

    private final SearchService searchService;

    SearchController(SearchService searchService){
        this.searchService = searchService;
    }

    @PostMapping("/search/{place}/")
    public String search(@PathVariable String place, @RequestBody SearchRequestBody requestBody){

        return searchService.searchShopsNearTo(place);
    }
}
