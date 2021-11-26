package com.tomtom.bank.service;

import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository bankRepository;

    public AccountService(AccountRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Account persistAccount(final Account account) {
        return bankRepository.save(account);
    }
}
