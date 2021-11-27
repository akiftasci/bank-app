package com.tomtom.bank.util;

import com.tomtom.bank.dto.AccountDto;
import com.tomtom.bank.dto.AccountWrapperDto;
import com.tomtom.bank.entity.Account;

public class AccountUtil {
    public static Account convertWrapperDtoToEntity(final AccountWrapperDto wrapperDto) {
        final Account account = new Account();
        account.setName(wrapperDto.getAccount().getName());
        account.setLimits(wrapperDto.getAccount().getLimits());
        return account;
    }

    public static AccountWrapperDto converEntityToDto(final Account account) {
        final AccountWrapperDto wrapperDto = new AccountWrapperDto();

        AccountDto accountDto = new AccountDto(account.getName(),account.getLimits());

        return wrapperDto;
    }
}
