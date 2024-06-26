package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.BrandService;
import com.turkcell.rentacar.business.abstracts.FuelService;
import com.turkcell.rentacar.business.abstracts.ModelService;
import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.Model.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.Model.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.Model.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Model.GetAllModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Model.GetModelResponseById;
import com.turkcell.rentacar.business.dtos.responses.Model.UpdatedModelResponse;
import com.turkcell.rentacar.business.rules.ModelBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.Transmission;
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
    private FuelService fuelService;
    private TransmissionService transmissionService;
    private BrandService brandService;

    @Override
    public CreatedModelResponse add(CreateModelRequest createModelRequest) {
        modelBusinessRules.modelNameCannotBeDuplicated(createModelRequest.getName());
        Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
        Fuel fuel = modelMapperService.forResponse().map(fuelService.getById(createModelRequest.getFuelId()), Fuel.class);
        Transmission transmission = modelMapperService.forResponse()
                .map(transmissionService.getById(createModelRequest.getTransmissionId()), Transmission.class);
        Brand brand = modelMapperService.forResponse().map(brandService.getById(createModelRequest.getBrandId()), Brand.class);
        model.setCreateDate(LocalDateTime.now());
        model.setBrand(brand);
        model.setFuel(fuel);
        model.setTransmission(transmission);

        Model savedModel = modelRepository.save(model);

        CreatedModelResponse createdModelResponse =
                this.modelMapperService.forResponse().map(savedModel, CreatedModelResponse.class);

        return createdModelResponse;
    }

    @Override
    public List<GetAllModelResponse> getAll() {
        List<Model> models = modelRepository.findAll();
        List<GetAllModelResponse> getModelResponseByIdList = new ArrayList<>();
        for (Model model : models) {
            GetAllModelResponse getModelResponseById = this.modelMapperService.forResponse().map(model, GetAllModelResponse.class);
            getModelResponseByIdList.add(getModelResponseById);
        }
        return getModelResponseByIdList;
    }

    @Override
    public GetModelResponseById getById(int id) {
        modelBusinessRules.modelMustExists(id);
        Model model = modelRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(model, GetModelResponseById.class);
    }

    @Override
    public UpdatedModelResponse update(UpdateModelRequest updateModelRequest) {
        modelBusinessRules.modelMustExists(updateModelRequest.getId());
        Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
        model.setUpdateDate(LocalDateTime.now());
        Model updatedModel = modelRepository.save(model);
        UpdatedModelResponse updatedModelResponse = this.modelMapperService.forResponse().map(updatedModel, UpdatedModelResponse.class);
        updatedModelResponse.setUpdateDate(updatedModel.getUpdateDate());
        return updatedModelResponse;
    }

    @Override
    public void delete(int id) {
        modelBusinessRules.modelMustExists(id);
        modelRepository.deleteById(id);
    }
}
