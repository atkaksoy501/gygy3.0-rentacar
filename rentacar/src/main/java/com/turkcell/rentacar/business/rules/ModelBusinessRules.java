package com.turkcell.rentacar.business.rules;

import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.FuelRepository;
import com.turkcell.rentacar.dataAccess.abstracts.ModelRepository;
import com.turkcell.rentacar.entities.concretes.Fuel;
import com.turkcell.rentacar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private ModelRepository modelRepository;

    public void modelNameCannotBeDuplicated(String modelName) {
        Optional<Model> model = modelRepository.findByNameIgnoreCase(modelName);
        if (model.isPresent()) {
            throw new BusinessException("ModelExists");
        }
    }

    public void modelMustExists(int modelId) {
        Optional<Model> model = modelRepository.findById(modelId);
        if (!model.isPresent()) {
            throw new BusinessException("ModelNotExists");
        }
    }
}
