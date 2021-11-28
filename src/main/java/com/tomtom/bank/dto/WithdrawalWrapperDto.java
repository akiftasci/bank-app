package com.tomtom.bank.dto;

import lombok.Getter;

@Getter
public class WithdrawalWrapperDto {

    WithdrawalDto withdrawal = new WithdrawalDto();

    public void setWithdrawalDto(WithdrawalDto withdrawal) {
        this.withdrawal = withdrawal;
    }
}
