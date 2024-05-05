package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.Brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.Brand.*;

import java.util.List;

public interface BrandService {
    CreatedBrandResponse add(CreateBrandRequest brand);
    List<GetAllBrandResponse> getAll();
    GetBrandResponseById getById(int id);
    UpdatedBrandResponse update(UpdateBrandRequest updateBrandRequest);
    void delete(int id);

}
