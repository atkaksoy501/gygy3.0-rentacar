package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.*;
import com.turkcell.rentacar.business.dtos.requests.CreateRentalRequest;
import com.turkcell.rentacar.business.dtos.requests.CreditCardPaymentRequest;
import com.turkcell.rentacar.business.dtos.requests.UpdateRentalWithExtraRequest;
import com.turkcell.rentacar.business.dtos.responses.CreatedRentalResponse;
import com.turkcell.rentacar.business.dtos.responses.GotRentalResponse;
import com.turkcell.rentacar.business.rules.CarBusinessRules;
import com.turkcell.rentacar.business.rules.FindexBusinessRules;
import com.turkcell.rentacar.business.rules.PaymentBusinessRules;
import com.turkcell.rentacar.business.rules.RentalBusinessRules;
import com.turkcell.rentacar.core.entities.Customer;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.RentalRepository;
import com.turkcell.rentacar.entities.concretes.*;
import com.turkcell.rentacar.entities.concretes.enums.CarStatus;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RentalManager implements RentalService {

    private RentalRepository rentalRepository;
    private RentalBusinessRules rentalBusinessRules;
    private CarBusinessRules carBusinessRules;
    private FindexBusinessRules findexBusinessRules;
    private ModelMapperService modelMapperService;
    private IndividualCustomerService individualCustomerService;
    private BusinessCustomerService businessCustomerService;
    private CarService carService;
    private PaymentBusinessRules paymentBusinessRules;
    private PaymentService paymentService;


    @Override
    public CreatedRentalResponse addRentalForBusiness(CreateRentalRequest rental) {
        carBusinessRules.carMustExists(rental.getCarId());
        carBusinessRules.carIsInMaintenance(rental.getCarId());
        carBusinessRules.carIsAlreadyRented(rental.getCarId());
        paymentBusinessRules.paymentMustConfirmed(rental.getCreditCardPaymentRequest());
        BusinessCustomer businessCustomer = modelMapperService.forResponse()
                .map(businessCustomerService.getById(rental.getCustomerId()), BusinessCustomer.class);
        return getCreatedRentalResponse(rental, businessCustomer.getIdentityNo(), businessCustomer);
    }

    @Override
    public CreatedRentalResponse addRentalForIndividual(CreateRentalRequest rental) {
        carBusinessRules.carMustExists(rental.getCarId());
        carBusinessRules.carIsInMaintenance(rental.getCarId());
        carBusinessRules.carIsAlreadyRented(rental.getCarId());
        paymentBusinessRules.paymentMustConfirmed(rental.getCreditCardPaymentRequest());
        IndividualCustomer individualCustomer = modelMapperService.forResponse()
                .map(individualCustomerService.getById(rental.getCustomerId()), IndividualCustomer.class);
        return getCreatedRentalResponse(rental, individualCustomer.getIdentityNo(), individualCustomer);
    }

    private CreatedRentalResponse getCreatedRentalResponse(CreateRentalRequest rental, String identityNo, Customer customer) {
//        Car car = modelMapperService.forResponse()
//                .map(carService.getById(rental.getCarId()), Car.class);
        ModelMapper modelMapper = new ModelMapper(); //upper method assignes "createDate" variable to all dates.
        Car car = modelMapper.map(carService.getById(rental.getCarId()), Car.class);
        findexBusinessRules.findexScoreMustEnough(identityNo, car.getModel().getRequiredFindexScore());
        Rental dbRental = modelMapperService.forRequest().map(rental, Rental.class);
        car.setStatus(CarStatus.RENTAL);
        carService.updateCarStatus(car);
        dbRental.setCar(car);
        dbRental.setCreateDate(LocalDateTime.now());
        dbRental.setDateRented(LocalDateTime.now());
        dbRental.setDateReturned(rental.getReturnDate());
        dbRental.setCustomer(customer);
        if (rental.getExtras() != null) {
            List<RentalExtras> extras = rental.getExtras().stream()
                    .map(extra -> {
                        RentalExtras rentalExtra = modelMapperService.forRequest().map(extra, RentalExtras.class);
                        rentalExtra.setRental(dbRental);
                        rentalExtra.setCreateDate(LocalDateTime.now());
                        return rentalExtra;
                    })
                    .collect(Collectors.toList());
            dbRental.setExtras(extras);
        }

        CreatedRentalResponse createdRental = modelMapperService.forResponse().map(rentalRepository.save(dbRental), CreatedRentalResponse.class);
        paymentService.add(dbRental, rental.getCreditCardPaymentRequest().getAmount());
        return createdRental;

    }

    @Override
    public GotRentalResponse getById(int id) {
        rentalBusinessRules.rentalMustExists(id);
        return modelMapperService.forResponse().map(rentalRepository.findById(id).orElse(null), GotRentalResponse.class);
    }

    @Override
    public Rental updateRentalWithExtras(UpdateRentalWithExtraRequest extraRequest) {
        rentalBusinessRules.rentalMustExists(extraRequest.getRentalId());
        Rental rental = modelMapperService.forRequest().map(this.getById(extraRequest.getRentalId()), Rental.class); //todo: sorunlu
        List<RentalExtras> extrasList = extraRequest.getExtras().stream().map(
                extra -> {
                    RentalExtras rentalExtra = modelMapperService.forRequest().map(extra, RentalExtras.class);
                    rentalExtra.setRental(rental);
                    rentalExtra.setCreateDate(LocalDateTime.now());
                    return rentalExtra;
                }
        ).collect(Collectors.toList());
        rental.setExtras(extrasList);
        rental.setUpdateDate(LocalDateTime.now());
        return rentalRepository.save(rental);
    }
}
