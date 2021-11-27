package com.tomtom.bank.service;

import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository bankRepository) {
        this.accountRepository = bankRepository;
    }

    public Account persistAccount(final Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(final Long id) {
        final Optional<Account> account = accountRepository.findById(id);
        if(account.isPresent()){
            return account.get();
        }
        throw new RuntimeException();
    }
}
