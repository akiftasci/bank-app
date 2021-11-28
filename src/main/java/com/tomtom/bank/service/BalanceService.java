package com.tomtom.bank.service;

import com.tomtom.bank.dto.BalanceDto;
import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class BalanceService {
    private final AccountRepository accountRepository;

    public BalanceService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BalanceWrapperDto getBalance(final Long id) {
        final BalanceDto balanceDto = new BalanceDto();
        final BalanceWrapperDto balanceWrapperDto = new BalanceWrapperDto();

        final Account account = accountRepository.findById(id).get();
        final float balance = account.getBalance();
        balanceDto.setAmount(balance);
        balanceWrapperDto.setBalanceDto(balanceDto);
        return balanceWrapperDto;
    }
}
