package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.Maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.Maintenance.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.Maintenance.GetMaintenanceResponseById;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/maintenances")
public class MaintenancesController {
    private MaintenanceService maintenanceService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedMaintenanceResponse add(@Valid @RequestBody CreateMaintenanceRequest createMaintenanceRequest) {

        return maintenanceService.sentToMaintenance(createMaintenanceRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GetMaintenanceResponseById getById(@PathVariable int id) {
        return maintenanceService.getById(id);
    }

    //todo: update, delete, getAll methods will be added
}
