package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.adapters.abstracts.FindexHttpAdapter;
import com.turkcell.rentacar.business.abstracts.FindexService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FindexManager implements FindexService {

    private FindexHttpAdapter findexHttpAdapter;

    @Override
    public int getScore(String nationalId) {
        String response = findexHttpAdapter.sendGetRequest("http://localhost:8082/api/v1/findex/" + nationalId);
        return Integer.parseInt(response);
    }
}
