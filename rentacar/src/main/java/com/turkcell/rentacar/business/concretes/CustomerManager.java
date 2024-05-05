package com.turkcell.rentacar.business.concretes;

import com.turkcell.rentacar.business.abstracts.CustomerService;
import com.turkcell.rentacar.business.messages.AuthMessages;
import com.turkcell.rentacar.core.utilities.exceptions.types.BusinessException;
import com.turkcell.rentacar.dataAccess.abstracts.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository
                .findCustomerByEmail(username)
                .orElseThrow(()-> new BusinessException(AuthMessages.LOGIN_FAILED));
    }
}
