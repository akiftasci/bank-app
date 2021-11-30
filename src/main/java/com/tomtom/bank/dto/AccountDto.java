package com.tomtom.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDto  {
    Long id;
    String name;
    Float limits;
    String createdAt;

    public AccountDto(){

    }

    public AccountDto(Long id, String name, float limits, String createdAt){
        this.name =name;
        this.limits=limits;
        this.id=id;
        this.createdAt=createdAt;
    }
}
