package com.tomtom.bank.service;

import com.tomtom.bank.dto.BalanceDto;
import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DepositService {
    private final AccountRepository accountRepository;
    public DepositService(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }
    public BalanceWrapperDto deposit(final Long id, float amount) {
        final BalanceDto balanceDto = new BalanceDto();
        final BalanceWrapperDto balanceWrapperDto = new BalanceWrapperDto();
        final Optional<Account> account = accountRepository.findById(id);

        if (account.isPresent()){
            float balance = account.get().getBalance();
            balance= balance + amount;
            account.get().setBalance(balance);
            balanceDto.setAmount(balance);
            balanceWrapperDto.setBalanceDto(balanceDto);
            return balanceWrapperDto;
        }
        throw new RuntimeException();
    }
}
