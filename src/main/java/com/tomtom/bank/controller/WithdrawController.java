package com.tomtom.bank.controller;

import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.dto.WithdrawalDto;
import com.tomtom.bank.dto.WithdrawalWrapperDto;
import com.tomtom.bank.service.WithdrawService;
import com.tomtom.bank.util.WithdrawalUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WithdrawController {
    private final WithdrawService withdrawService;

    public WithdrawController(final WithdrawService withdrawService){
        this.withdrawService=withdrawService;
    }
    @PostMapping(value = "accounts/{id}/withdrawal")
    public BalanceWrapperDto withdrawal(@PathVariable Long id, @RequestBody final WithdrawalWrapperDto requestBody){
        WithdrawalDto withdrawalDto = WithdrawalUtil.convertWithdrawalToWithdrawalDto(requestBody);
        BalanceWrapperDto balanceWrapperDto = withdrawService.withdrawal(id, withdrawalDto.getAmount());
        return balanceWrapperDto;
    }
}
