package com.tomtom.bank.controller;

import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.dto.DepositDto;
import com.tomtom.bank.dto.DepositWrapperDto;
import com.tomtom.bank.service.DepositService;
import com.tomtom.bank.util.DepositUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {
    private final DepositService depositService;

    public DepositController(final DepositService depositService){
        this.depositService=depositService;
    }

    @PostMapping(value = "accounts/{id}/deposit")
    public BalanceWrapperDto deposit(@PathVariable Long id, @RequestBody final DepositWrapperDto depositWrapperDto){
        DepositDto depositDto = DepositUtil.convertDepositWrapperToDepositDto(depositWrapperDto);
        final BalanceWrapperDto  balanceWrapperDto = depositService.deposit(id, depositDto.getAmount());
        return balanceWrapperDto;
    }
}
