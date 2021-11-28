package com.tomtom.bank.dto;

import lombok.Getter;

@Getter
public class BalanceWrapperDto {
    BalanceDto balance = new BalanceDto();

    public void setBalanceDto(BalanceDto balance){
        this.balance=balance;
    }
}
