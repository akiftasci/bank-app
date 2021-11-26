package com.tomtom.bank.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AccountDto  {
    String name;
    float limits;

    public AccountDto(String name, float limits){
        this.name =name;
        this.limits=limits;
    }
}
