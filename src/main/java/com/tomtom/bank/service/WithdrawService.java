package com.tomtom.bank.service;

import com.tomtom.bank.dto.BalanceDto;
import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.entity.Transactions;
import com.tomtom.bank.exception.ApiRequestException;
import com.tomtom.bank.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
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
        final List<Transactions> transactionDtoList = new ArrayList<>();
        final Transactions transactions = new Transactions();

        final Account account = accountRepository.findById(id).get();

        float balance = account.getBalance();
        final float limits = account.getLimits();
        if (balance < limits){
            throw new ApiRequestException("Balance is lower than limit!");
        }
        balance = balance - amount;
        account.setBalance(balance);
        transactions.setType("withdraw");
        transactions.setAmount(amount);
        transactions.setAccount(account);
        transactionDtoList.add(transactions);
        account.setTransactions(transactionDtoList);

        accountRepository.save(account);

        balanceDto.setAmount(balance);
        balanceWrapperDto.setBalanceDto(balanceDto);
        return balanceWrapperDto;
    }
}
