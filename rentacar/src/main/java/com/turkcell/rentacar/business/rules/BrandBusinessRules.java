package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class BrandBusinessRules {
    BrandRepository brandRepository;

    public void brandNameCannotBeDuplicated(String brandName) {
        Optional<Brand> brand = brandRepository.findByNameIgnoreCase(brandName);
        if (brand.isPresent()) {
            throw new BusinessException("BrandExists");
        }
    }

    public void brandMustExists(int brandId) {
        Optional<Brand> brand = brandRepository.findById(brandId);
        if (!brand.isPresent()) {
            throw new BusinessException("BrandNotExists");
        }
    }
}
