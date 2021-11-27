package com.tomtom.bank.dto;

import lombok.Getter;

@Getter
public class DepositWrapperDto {
    DepositDto depositDto = new DepositDto();

    public void setDepositDto(DepositDto depositDto) {
        this.depositDto = depositDto;
    }
}
