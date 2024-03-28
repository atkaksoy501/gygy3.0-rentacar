package com.turkcell.rentacar.business.abstracts;

import com.turkcell.rentacar.business.dtos.requests.Transmission.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.Transmission.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.Transmission.*;

import java.util.List;

public interface TransmissionService {
    CreatedTransmissionResponse add(CreateTransmissionRequest createTransmissionRequest);
    List<GetAllTransmissionResponse> getAll();
    GetTransmissionResponseById getById(int id);
    UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest);
    void delete(int id);
}
