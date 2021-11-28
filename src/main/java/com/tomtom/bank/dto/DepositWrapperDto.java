package com.tomtom.bank.dto;

import lombok.Getter;

@Getter
public class DepositWrapperDto {

    DepositDto deposit = new DepositDto();

    public void setDepositDto(DepositDto deposit) {
        this.deposit = deposit;
    }
}
