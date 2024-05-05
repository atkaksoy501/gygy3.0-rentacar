package com.turkcell.rentacar.api.controllers;


import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.dtos.requests.Brand.CreateBrandRequest;
import com.turkcell.rentacar.business.dtos.requests.Brand.UpdateBrandRequest;
import com.turkcell.rentacar.business.dtos.responses.Brand.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/brands")
public class BrandsController {

    private BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponse add(@Valid @RequestBody CreateBrandRequest brand) {
        return brandService.add(brand);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponse> getAll() {
        return brandService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetBrandResponseById getById(@PathVariable int id) {
        return brandService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedBrandResponse update(@Valid @RequestBody UpdateBrandRequest updateBrandRequest) {
        return brandService.update(updateBrandRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        brandService.delete(id);
    }


}
