package com.tomtom.bank.service;

import com.tomtom.bank.dto.TransactionDto;
import com.tomtom.bank.dto.TransactionWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.entity.Transactions;
import com.tomtom.bank.repository.AccountRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;

    public TransactionService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public List<TransactionDto> getTransactions(final Long id){
        final TransactionWrapperDto transactionWrapperDto = new TransactionWrapperDto();
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        final Account account = accountRepository.findById(id).get();
        final List<Transactions> transactions = account.getTransactions();

        return transactions.stream().map(transaction -> {
            final TransactionDto transactionDto = new TransactionDto();
            transactionDto.setType(transaction.getType());
            transactionDto.setAmount(transaction.getAmount());
            return transactionDto;
        }).collect(Collectors.toList());


    }
}
