package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.dtos.requests.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.*;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;

    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        modelBusinessRules.modelNameCannotBeDuplicated(createModelRequest.getName());
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        model.setCreateDate(LocalDateTime.now());

        Model savedModel = modelRepository.save(model);

        CreatedModelResponse createdModelResponse =
                this.modelMapperService.forResponse().map(savedModel, CreatedModelResponse.class);

        return createdModelResponse;
    }

    @Override
    public List<GotModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GotModelResponse> gotModelResponseList = new ArrayList<>();
        for (Model model : models) {
            GotModelResponse gotModelResponse = this.modelMapperService.forResponse().map(model, GotModelResponse.class);
            gotModelResponseList.add(gotModelResponse);
        }
        return gotModelResponseList;
    }

    @Override
    public GotModelResponse getById(int id) {
        modelBusinessRules.modelMustExists(id);
        Model model = modelRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(model, GotModelResponse.class);
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest) {
        modelBusinessRules.modelMustExists(updateModelRequest.getId());
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        model.setUpdateDate(LocalDateTime.now());
        Model updatedModel = modelRepository.save(model);
        UpdatedModelResponse updatedModelResponse = this.modelMapperService.forResponse().map(updatedModel, UpdatedModelResponse.class);
        updatedModelResponse.setUpdatedDate(updatedModel.getUpdateDate());
        return updatedModelResponse;
    }

    @Override
    public void delete(int id) {
        modelBusinessRules.modelMustExists(id);
        modelRepository.deleteById(id);
    }
}
