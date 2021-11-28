package com.tomtom.bank.dto;

import lombok.Getter;

@Getter
public class AccountWrapperDto {

    AccountDto account = new AccountDto();

    public void setAccountDto(AccountDto account){
        this.account=account;
    }
}
