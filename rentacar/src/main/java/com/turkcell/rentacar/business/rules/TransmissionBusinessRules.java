package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransmissionBusinessRules {

    private TransmissionRepository transmissionRepository;

    public void transmissionNameCannotBeDuplicated(String transmissionName) {
        Optional<Transmission> transmission = transmissionRepository.findByNameIgnoreCase(transmissionName);
        if (transmission.isPresent()) {
            throw new BusinessException("TransmissionExists");
        }
    }

    public void transmissionMustExists(int transmissionId) {
        Optional<Transmission> transmission = transmissionRepository.findById(transmissionId);
        if (!transmission.isPresent()) {
            throw new BusinessException("TransmissionNotExists");
        }
    }
}
