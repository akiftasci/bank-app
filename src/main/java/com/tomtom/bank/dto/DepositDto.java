package com.tomtom.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepositDto {
    float amount;

    public DepositDto() {

    }

    public DepositDto(float amount) {
        this.amount = amount;
    }
}
