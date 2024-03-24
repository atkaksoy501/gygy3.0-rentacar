package com.turkcell.rentacar.core.utilities.mapping;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
}
