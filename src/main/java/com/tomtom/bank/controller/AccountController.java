package com.tomtom.bank.controller;

import com.tomtom.bank.dto.AccountDto;
import com.tomtom.bank.dto.AccountWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.service.AccountService;
import com.tomtom.bank.util.AccountUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
    @Value("${defaults.account.limits}")
    private float defaultPaymentLimits;

    private final AccountService accountService;

    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping(value = "/accounts")
    public AccountWrapperDto persistAccount(@RequestBody final AccountWrapperDto requestBody) {
        final AccountDto accountDto = requestBody.getAccount();
        if (accountDto.getLimits() == null) {
            accountDto.setLimits(defaultPaymentLimits);
        }

        Account account = AccountUtil.convertWrapperDtoToEntity(requestBody);
        final Account persistAccount = accountService.persistAccount(account);
        return AccountUtil.converEntityToDto(persistAccount);

    }

    @GetMapping(value = "/accounts/{id}")
    public AccountWrapperDto getAccountById(@PathVariable Long id) {
        Account account = accountService.getAccount(id);
        AccountWrapperDto wrapperDto = AccountUtil.converEntityToDto(account);
        return wrapperDto;
    }
}
