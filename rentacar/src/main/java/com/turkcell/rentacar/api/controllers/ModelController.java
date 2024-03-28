package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.Model.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.Model.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.Model.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Model.GetAllModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Model.GetModelResponseById;
import com.turkcell.rentacar.business.dtos.responses.Model.UpdatedModelResponse;
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
    public List<GetAllModelResponse> getAll() {
        return modelService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetModelResponseById getById(@PathVariable int id) {
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
