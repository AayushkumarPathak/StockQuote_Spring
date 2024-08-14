package com.stock.stock.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
    private final RestTemplate restTemplate;

    public RestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getStockData(String url) {
        return restTemplate.getForObject(url, String.class);
    }
    
}
