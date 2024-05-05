package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CarService;
import com.turkcell.rentacar.business.abstracts.MaintenanceService;
import com.turkcell.rentacar.business.dtos.requests.Maintenance.CreateMaintenanceRequest;
import com.turkcell.rentacar.business.dtos.responses.Maintenance.CreatedMaintenanceResponse;
import com.turkcell.rentacar.business.dtos.responses.Maintenance.GetMaintenanceResponseById;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.business.rules.MaintenanceBusinessRules;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.MaintenanceRepository;
import com.turkcell.rentacar.entities.concretes.Car;
import com.turkcell.rentacar.entities.concretes.Maintenance;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class MaintenanceManager implements MaintenanceService {

    private MaintenanceRepository maintenanceRepository;
    private MaintenanceBusinessRules maintenanceBusinessRules;
    private CarBusinessRules carBusinessRules;
    private ModelMapperService modelMapperService;
    private CarService carService;
    @Override
    public CreatedMaintenanceResponse sentToMaintenance(CreateMaintenanceRequest createMaintenanceRequest) {
        carBusinessRules.carMustExists(createMaintenanceRequest.getCarId());
        carBusinessRules.carIsInMaintenance(createMaintenanceRequest.getCarId());
        carBusinessRules.carIsAlreadyRented(createMaintenanceRequest.getCarId());
        Maintenance maintenance = new Maintenance();
        Car car = modelMapperService.forResponse()
                .map(carService.getById(createMaintenanceRequest.getCarId()), Car.class);
        car.setStatus(CarStatus.MAINTENANCE);
        maintenance.setCar(car);
        maintenance.setCreateDate(LocalDateTime.now());
        maintenance.setDateSent(LocalDateTime.now());
        return modelMapperService.forResponse().map(maintenanceRepository.save(maintenance), CreatedMaintenanceResponse.class);
    }

    @Override
    public GetMaintenanceResponseById getById(int id) {
        maintenanceBusinessRules.maintenanceMustExists(id);
        Maintenance maintenance = maintenanceRepository.findById(id).orElse(null);
        return modelMapperService.forResponse().map(maintenance, GetMaintenanceResponseById.class);
    }

    //todo: returnCarFromMaintenance method oluşturulacak

    //rental
    //maintenance
    //findex
    //payment
}
