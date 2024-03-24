package com.turkcell.rentacar.business.dtos.responses;

import com.turkcell.rentacar.entities.concretes.Maintenance;
import com.turkcell.rentacar.entities.concretes.Model;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GotCarResponse {
    private int id;

    private Model model;

    private CarStatus status;

    private String name;

    private int modelYear;

    private String plate;

    private double dailyPrice;

    private List<Maintenance> maintenances;
}
