package com.turkcell.rentacar.adapters.concretes;

import com.turkcell.rentacar.adapters.abstracts.FindexHttpAdapter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@NoArgsConstructor
public class FindexRestTemplateAdapter implements FindexHttpAdapter {
    private RestTemplate restTemplate;
    @Override
    public String sendGetRequest(String url) {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
