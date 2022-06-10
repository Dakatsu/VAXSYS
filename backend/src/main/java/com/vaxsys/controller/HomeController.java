package com.vaxsys.controller;

import com.vaxsys.dto.AccountDto;
import com.vaxsys.dto.LoginDto;
import com.vaxsys.dto.PatientCreationDto;
import com.vaxsys.entity.Account;
import com.vaxsys.mapper.AccountMapper;
import com.vaxsys.dto.AccountCreationDto;
import com.vaxsys.service.AccountService;
import com.vaxsys.service.PatientVerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.vaxsys.constant.Role.PATIENT;

@RestController
@RequestMapping("/home")
public class HomeController {

    private final AccountService accountService;

    @Autowired
    private PatientVerificationService patientVerificationService;

    public HomeController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public AccountDto login(@RequestBody LoginDto loginDto,
                            HttpServletRequest request, HttpServletResponse response) throws IOException {

        Account account;
        try {
            account = accountService.login(loginDto.getEmail(), loginDto.getPassword(), request);
        } catch (Exception e) {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Invalid email or password!");
            return null;
        }
        return AccountMapper.INSTANCE.map(account);
    }

    @PostMapping("/register")
    public AccountDto register(@RequestBody PatientCreationDto request,
                               HttpServletResponse response) throws IOException {
        Account account;
        try {
            account = patientVerificationService.createPatientAccountWithID(request, PATIENT.map());
        } catch (Exception e) {
            response.sendError(HttpStatus.FORBIDDEN.value(), e.getMessage());
            return null;
        }
        return AccountMapper.INSTANCE.map(account);
    }
}
