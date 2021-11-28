package com.tomtom.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WithdrawalDto {
    float amount;

    public WithdrawalDto() {

    }

    public WithdrawalDto(float amount) {
        this.amount = amount;
    }
}
