package com.tomtom.bank.util;

import com.tomtom.bank.dto.AccountDto;
import com.tomtom.bank.dto.AccountWrapperDto;
import com.tomtom.bank.entity.Account;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AccountUtil {
    public static Account convertWrapperDtoToEntity(final AccountWrapperDto wrapperDto) {
        final Account account = new Account();
        account.setName(wrapperDto.getAccount().getName());
        account.setLimits(wrapperDto.getAccount().getLimits());
        return account;
    }

    public static AccountWrapperDto converEntityToDto(final Account account) {
        final AccountWrapperDto wrapperDto = new AccountWrapperDto();
        final AccountDto accountDto = new AccountDto(account.getId(),account.getName(),account.getLimits(),convertDateToString(account.getCreated()));
        wrapperDto.setAccountDto(accountDto);

        return wrapperDto;
    }

    public static String convertDateToString(final LocalDateTime created) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return formatter.format(created);
    }
}
