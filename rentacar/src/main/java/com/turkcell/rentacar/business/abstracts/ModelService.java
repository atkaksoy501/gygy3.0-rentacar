package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Model.CreateModelRequest;
import com.turkcell.rentacar.business.dtos.requests.Model.UpdateModelRequest;
import com.turkcell.rentacar.business.dtos.responses.Model.CreatedModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Model.GetAllModelResponse;
import com.turkcell.rentacar.business.dtos.responses.Model.GetModelResponseById;
import com.turkcell.rentacar.business.dtos.responses.Model.UpdatedModelResponse;

import java.util.List;

public interface ModelService {
    CreatedModelResponse add(CreateModelRequest createModelRequest);
    List<GetAllModelResponse> getAll();
    GetModelResponseById getById(int id);
    UpdatedModelResponse update(UpdateModelRequest updateModelRequest);
    void delete(int id);
}
