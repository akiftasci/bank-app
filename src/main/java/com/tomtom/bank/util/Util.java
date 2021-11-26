package com.tomtom.bank.util;

import com.tomtom.bank.dto.WrapperDto;
import com.tomtom.bank.entity.Account;

public class Util {
    public static Account convertWrapperDtoToEntity(final WrapperDto wrapperDto) {
        final Account account = new Account();
        account.setName(wrapperDto.getAccount().getName());
        account.setLimits(wrapperDto.getAccount().getLimits());
        return account;
    }

    public static WrapperDto converEntityToDto(final Account account) {
        final WrapperDto wrapperDto = new WrapperDto();
        wrapperDto.setAccountDto(account);
        return wrapperDto;
    }
}
