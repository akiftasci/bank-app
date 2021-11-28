package com.tomtom.bank.controller;

import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.service.BalanceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    private final BalanceService balanceService;

    public BalanceController(final BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @PostMapping(value = "accounts/{id}/balance")
    public BalanceWrapperDto balance(@PathVariable Long id) {
        BalanceWrapperDto balanceWrapperDto = balanceService.getBalance(id);
        return balanceWrapperDto;
    }
}
