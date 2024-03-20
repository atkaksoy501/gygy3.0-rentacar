package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.CreateFuelRequest;
import com.turkcell.rentacar.business.dtos.requests.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.*;
import com.turkcell.rentacar.business.rules.TransmissionBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Brand;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {

    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;
    private TransmissionBusinessRules transmissionBusinessRules;

    @Override
    public CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest) {
        transmissionBusinessRules.transmissionNameCannotBeDuplicated(createTransmissionRequest.getName());
        Transmission transmission = this.modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);
        transmission.setCreateDate(LocalDateTime.now());

        Transmission savedTransmission = transmissionRepository.save(transmission);

        CreatedTransmissionResponse createdTransmissionResponse =
                this.modelMapperService.forResponse().map(savedTransmission, CreatedTransmissionResponse.class);

        return createdTransmissionResponse;
    }

    @Override
    public List<GotTransmissionResponse> getAll() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        List<GotTransmissionResponse> gotTransmissionResponseList = new ArrayList<>();
        for (Transmission transmission : transmissions) {
            GotTransmissionResponse gotTransmissionResponse = this.modelMapperService.forResponse().map(transmission, GotTransmissionResponse.class);
            gotTransmissionResponseList.add(gotTransmissionResponse);
        }
        return gotTransmissionResponseList;
    }

    @Override
    public GotTransmissionResponse getById(int id) {
        transmissionBusinessRules.transmissionMustExists(id);
        Transmission transmission = transmissionRepository.findById(id).orElse(null);
        return this.modelMapperService.forResponse().map(transmission, GotTransmissionResponse.class);
    }

    @Override
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        transmissionBusinessRules.transmissionMustExists(updateTransmissionRequest.getId());
        Transmission transmission = this.modelMapperService.forRequest().map(updateTransmissionRequest, Transmission.class);
        transmission.setUpdateDate(LocalDateTime.now());
        Transmission updatedTransmission = transmissionRepository.save(transmission);
        UpdatedTransmissionResponse updatedTransmissionResponse = this.modelMapperService.forResponse().map(updatedTransmission, UpdatedTransmissionResponse.class);
        updatedTransmissionResponse.setUpdatedDate(updatedTransmission.getUpdateDate());
        return updatedTransmissionResponse;
    }

    @Override
    public void delete(int id) {
        transmissionBusinessRules.transmissionMustExists(id);
        transmissionRepository.deleteById(id);
    }
}
