package com.tomtom.bank.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class TransactionWrapperDto {

    List<TransactionDto> transactions = new ArrayList<>();

    public void setTransactions(List<TransactionDto> transactions){
        this.transactions = transactions;
    }
}
