package com.tomtom.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDto {
    String type;
    float amount;

    public TransactionDto(){

    }
    public TransactionDto(String type, float amount){
        this.type=type;
        this.amount=amount;
    }
}
