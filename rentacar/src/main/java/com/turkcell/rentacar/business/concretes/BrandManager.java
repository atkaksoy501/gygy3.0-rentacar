package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.Brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.Brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.Brand.*;
import com.turkcell.rentacar.business.dtos.responses.Fuel.GetAllFuelResponse;
import com.turkcell.rentacar.business.rules.BrandBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BrandRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BrandManager implements BrandService {

    private BrandRepository brandRepository;
    private ModelMapperService modelMapperService;
    private BrandBusinessRules brandBusinessRules;

    @Override
    public CreatedBrandResponse add(CreateBrandRequest createBrandRequest) {
        brandBusinessRules.brandNameCannotBeDuplicated(createBrandRequest.getName());
        Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
        brand.setCreateDate(LocalDateTime.now());

        Brand savedBrand = brandRepository.save(brand);

        CreatedBrandResponse createdBrandResponse =
                this.modelMapperService.forResponse().map(savedBrand, CreatedBrandResponse.class);

        return createdBrandResponse;
    }

    @Override
    public List<GetAllBrandResponse> getAll() {
        List<Brand> brands = brandRepository.findAll();
        List<GetAllBrandResponse> getBrandResponseList = new ArrayList<>();
        for (Brand brand : brands) {
            GetAllBrandResponse getBrandResponse = this.modelMapperService.forResponse().map(brand, GetAllBrandResponse.class);
            getBrandResponseList.add(getBrandResponse);
        }
        return getBrandResponseList;
    }

    @Override
    public GetBrandResponseById getById(int id) {
        brandBusinessRules.brandMustExists(id);
        Brand brand = brandRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(brand, GetBrandResponseById.class);
    }

    @Override
    public UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest) {
        brandBusinessRules.brandMustExists(updateBrandRequest.getId());
        Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
        brand.setUpdateDate(LocalDateTime.now());
        Brand updatedBrand = brandRepository.save(brand);
        UpdatedBrandResponse updatedBrandResponse = this.modelMapperService.forResponse().map(updatedBrand, UpdatedBrandResponse.class);
        updatedBrandResponse.setUpdateDate(updatedBrand.getUpdateDate());
        return updatedBrandResponse;
    }

    @Override
    public void delete(int id) {
        brandBusinessRules.brandMustExists(id);
        brandRepository.deleteById(id);
    }
}
