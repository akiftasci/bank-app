package com.tomtom.bank.dto;

import lombok.Getter;

@Getter
public class BalanceWrapperDto {
    BalanceDto balanceDto = new BalanceDto();

    public void setBalanceDto(BalanceDto balanceDto){
        this.balanceDto=balanceDto;
    }
}
