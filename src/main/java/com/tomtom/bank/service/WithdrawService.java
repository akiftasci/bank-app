package com.tomtom.bank.service;

import com.tomtom.bank.dto.BalanceDto;
import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.dto.WithdrawalWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class WithdrawService {
    private final AccountRepository accountRepository;

    public WithdrawService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BalanceWrapperDto withdrawal(final Long id, final float amount) {
        final BalanceDto balanceDto = new BalanceDto();
        final BalanceWrapperDto balanceWrapperDto = new BalanceWrapperDto();

        final Account account = accountRepository.findById(id).get();
        float balance = account.getBalance();
        if(amount > balance){
            throw new RuntimeException();
        }
        if (amount > account.getLimits()){
            throw new RuntimeException();
        }
        balance = balance - amount;
        account.setBalance(balance);
        accountRepository.save(account);
        balanceDto.setAmount(balance);
        balanceWrapperDto.setBalanceDto(balanceDto);
        return balanceWrapperDto;
    }
}
