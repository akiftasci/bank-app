package com.tomtom.bank.dto;

import com.tomtom.bank.entity.Account;
import lombok.Getter;

@Getter
public class WrapperDto {

    Account account = new Account();

    public void setAccountDto(Account account){
        this.account=account;
    }
}
