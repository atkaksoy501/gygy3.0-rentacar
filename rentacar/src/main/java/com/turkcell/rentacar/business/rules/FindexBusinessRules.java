package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.business.abstracts.FindexService;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindexBusinessRules {
    private FindexService findexService;

    public void findexScoreMustEnough(String nationalId, int minimumFindexScore) {
        int score = findexService.getScore(nationalId);
        if (score < minimumFindexScore) {
            throw new BusinessException("Findex score is not enough.");
        }
    }
}
