package com.turkcell.rentacar.api.controllers;

import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.GotMaintenanceResponse;
import com.turkcell.rentacar.business.rules.MaintenanceBusinessRules;
import com.turkcell.rentacar.business.rules.RentalBusinessRules;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Maintenance;
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
    public CreatedMaintenanceResponse add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) {

        return maintenanceService.sentToMaintenance(createMaintenanceRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GotMaintenanceResponse getById(@PathVariable int id) {
        return maintenanceService.getById(id);
    }
}
