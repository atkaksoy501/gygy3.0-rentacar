package com.turkcell.rentacar.adapters;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@NoArgsConstructor
public class RestTemplateAdapter implements HttpAdapter{
    private RestTemplate restTemplate;
    @Override
    public String sendGetRequest(String url) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
