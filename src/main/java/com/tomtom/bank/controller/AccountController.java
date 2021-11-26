package com.tomtom.bank.controller;

import com.tomtom.bank.dto.WrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.service.AccountService;
import com.tomtom.bank.util.Util;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    private final AccountService accountService;

    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/accounts")
    public WrapperDto persistAccount(@RequestBody final WrapperDto requestBody) {
                        Account account = Util.convertWrapperDtoToEntity(requestBody);
        final Account persistAccount = accountService.persistAccount(account);
        return Util.converEntityToDto(persistAccount);

    }
    @GetMapping(value = "/accounts/{id}")
    public WrapperDto getAccountById(@PathVariable Long id){

    }
}
