package com.tomtom.bank.service;

import com.tomtom.bank.dto.BalanceDto;
import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    private final AccountRepository accountRepository;


    public DepositService( AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BalanceWrapperDto deposit(final Long id, float amount) {
        final BalanceDto balanceDto = new BalanceDto();
        final BalanceWrapperDto balanceWrapperDto = new BalanceWrapperDto();

        final Account account = accountRepository.findById(id).get();
        float balance = account.getBalance();
        balance =balance+amount;
        account.setBalance(balance);
        accountRepository.save(account);
        balanceDto.setAmount(balance);
        balanceWrapperDto.setBalanceDto(balanceDto);
            return balanceWrapperDto;

    }
}
