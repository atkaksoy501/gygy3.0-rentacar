package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.TransmissionService;
import com.turkcell.rentacar.business.dtos.requests.CreateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateTransmissionRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.GotTransmissionResponse;
import com.turkcell.rentacar.business.dtos.responses.UpdatedTransmissionResponse;
import com.turkcell.rentacar.entities.concretes.Transmission;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/transmissions")
public class TransmissionController {

    private TransmissionService transmissionService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionResponse add(@Valid @RequestBody CreateTransmissionRequest transmission) {
        return transmissionService.add(transmission);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GotTransmissionResponse> getAll() { //todo: GetAllTransmissionsResponse dto oluşturulacak
        return transmissionService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotTransmissionResponse getById(@PathVariable int id) { //todo: GetTransmissionResponseById dto olarak isimlendirilecek
        return transmissionService.getById(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public UpdatedTransmissionResponse update(@Valid @RequestBody UpdateTransmissionRequest updateTransmissionRequest) {
        return transmissionService.update(updateTransmissionRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        transmissionService.delete(id);
    }


}
