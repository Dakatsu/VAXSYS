package com.vaxsys.service;

import com.vaxsys.dto.AccountCreationDto;
import com.vaxsys.dto.PatientCreationDto;
import com.vaxsys.entity.Account;
import com.vaxsys.entity.Role;
import com.vaxsys.repository.AccountRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PatientVerificationService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public Account createPatientAccountWithID(PatientCreationDto request, Role role) {
        if (!EmailValidator.getInstance().isValid(request.getEmail())) {
            throw new IllegalArgumentException("Email is not valid.");
        }
        Account account = accountRepository.findByEmail(request.getEmail());
        if (Objects.nonNull(account)) {
            throw new IllegalArgumentException("Email is already used.");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());

        if(request.getIdNumber().length() !=8) {
            throw new RuntimeException("Invalid ID Number");
        }

        account = new Account(request.getFirstName(), request.getLastName(), request.getEmail(), encodedPassword, role, request.getIdNumber());

        accountRepository.save(account);
        return account;
    }
}
