package com.vaxsys.controller;

import com.vaxsys.dto.AccountDto;
import com.vaxsys.dto.AccountCreationDto;
import com.vaxsys.entity.Account;
import com.vaxsys.mapper.AccountMapper;
import com.vaxsys.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.vaxsys.constant.Role.ADMIN_CREATION_ROLES;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AccountService accountService;

    public AdminController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/account")
    public AccountDto createAccount(@RequestBody AccountCreationDto accountCreationDto,
                                    HttpServletResponse response) throws IOException {
        Account account;
        if (!ADMIN_CREATION_ROLES.contains(accountCreationDto.getRole())) {
            response.sendError(HttpStatus.FORBIDDEN.value(), "Admin could only create nurse or vendor accounts.");
            return null;
        }
        try {
            account = accountService.createAccount(accountCreationDto, accountCreationDto.getRole().map());
        } catch (Exception e) {
            response.sendError(HttpStatus.FORBIDDEN.value(), e.getMessage());
            return null;
        }
        return AccountMapper.INSTANCE.map(account);
    }
}
