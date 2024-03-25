package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.GotModelResponse;
import com.turkcell.rentacar.business.dtos.responses.UpdatedModelResponse;
import com.turkcell.rentacar.entities.concretes.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/models")
public class ModelController {

    private ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponse add(@Valid @RequestBody CreateModelRequest model) {
        return modelService.add(model);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GotModelResponse> getAll() { //todo: GetAllModelsResponse dto oluşturulacak
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotModelResponse getById(@PathVariable int id) { //todo: GetModelResponseById dto olarak isimlendirilecek
        return modelService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedModelResponse update(@Valid @RequestBody UpdateModelRequest updateModelRequest) {
        return modelService.update(updateModelRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        modelService.delete(id);
    }
}
