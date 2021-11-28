package com.tomtom.bank.controller;

import com.tomtom.bank.dto.TransactionDto;
import com.tomtom.bank.dto.TransactionWrapperDto;
import com.tomtom.bank.service.TransactionService;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {
    private final TransactionService transactionService;

    public TransactionsController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "accounts/{id}/transactions")
    public TransactionWrapperDto getTransactions(@PathVariable Long id) {
        final TransactionWrapperDto transactionWrapperDto = new TransactionWrapperDto();
        final List<TransactionDto> transactions = transactionService.getTransactions(id);
        transactionWrapperDto.setTransactions(transactions);
        return transactionWrapperDto;
    }
}
