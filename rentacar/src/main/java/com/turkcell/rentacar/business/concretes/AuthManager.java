package com.turkcell.rentacar.business.concretes;


import com.turkcell.rentacar.business.abstracts.AuthService;
import com.turkcell.rentacar.business.abstracts.CustomerService;
import com.turkcell.rentacar.business.dtos.requests.Auth.BusinessRegisterRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.IndividualRegisterRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.LoginRequest;
import com.turkcell.rentacar.business.dtos.requests.Auth.RegisterRequest;
import com.turkcell.rentacar.business.messages.AuthMessages;
import com.turkcell.rentacar.core.entities.Customer;
import com.turkcell.rentacar.core.services.JwtService;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.core.utilities.mapping.ModelMapperService;
import com.turkcell.rentacar.dataAccess.abstracts.BusinessCustomerRepository;
import com.turkcell.rentacar.dataAccess.abstracts.CustomerRepository;
import com.turkcell.rentacar.dataAccess.abstracts.IndividualCustomerRepository;
import com.turkcell.rentacar.entities.concretes.BusinessCustomer;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthManager implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapperService modelMapperService;

    private final IndividualCustomerRepository individualCustomerRepository;
    private final BusinessCustomerRepository businessCustomerRepository;


    @Override
    public String login(LoginRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));

        if(!authentication.isAuthenticated())
            throw new BusinessException(AuthMessages.LOGIN_FAILED);

        //sign a jwt token and return it
        return jwtService.generateToken(email);


    }

    @Override
    public void individualRegister(IndividualRegisterRequest request) {

        IndividualCustomer individualCustomer = modelMapperService.forRequest().map(request, IndividualCustomer.class);
        String encodedPassword = passwordEncoder.encode(individualCustomer.getPassword());
        individualCustomer.setPassword(encodedPassword);

        individualCustomerRepository.save(individualCustomer);
    }

    @Override
    public void businessRegister(BusinessRegisterRequest request) {
        BusinessCustomer businessCustomer = modelMapperService.forRequest().map(request, BusinessCustomer.class);
        String encodedPassword = passwordEncoder.encode(businessCustomer.getPassword());
        businessCustomer.setPassword(encodedPassword);

        businessCustomerRepository.save(businessCustomer);
    }


}
// Unit Test