package com.tomtom.bank.util;

import com.tomtom.bank.dto.AccountDto;
import com.tomtom.bank.dto.AccountWrapperDto;
import com.tomtom.bank.entity.Account;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountUtilTest {
    private final String desiredFormat = "12-11-2021 19:02";

    @Test
    public void testFormatDate() {
        final String formattedDate = AccountUtil.convertDateToString(LocalDateTime.of(2021, 11, 12, 19, 2));

        Assertions.assertThat(formattedDate).isEqualTo(desiredFormat);
    }

    @Test
    public void testConvertEntityToDto(){
        final Account account = new Account();

        account.setId((long)1);
        account.setName("account1");
        account.setLimits((float)121.1);
        account.setCreated(LocalDateTime.of(2021, 11, 12, 19, 2));

        final AccountWrapperDto accountWrapperDto = AccountUtil.converEntityToDto(account);

        Assertions.assertThat(accountWrapperDto.getAccount().getName()).isEqualTo("account1");
        Assertions.assertThat(accountWrapperDto.getAccount().getId()).isEqualTo((long)1);
        Assertions.assertThat(accountWrapperDto.getAccount().getCreatedAt()).isEqualTo(desiredFormat);
        Assertions.assertThat(accountWrapperDto.getAccount().getLimits()).isEqualTo((float)121.1);

    }

    @Test
    public void  testConvertWrapperDtpToEntity(){
        final AccountWrapperDto accountWrapperDto = new AccountWrapperDto();
        final AccountDto accountDto = new AccountDto();

        accountDto.setName("account1");
        accountDto.setId((long)1);
        accountDto.setCreatedAt(desiredFormat);
        accountDto.setLimits((float)121.1);
        accountWrapperDto.setAccountDto(accountDto);

        final Account account = AccountUtil.convertWrapperDtoToEntity(accountWrapperDto);

        Assertions.assertThat(account.getName()).isEqualTo("account1");
        Assertions.assertThat(account.getLimits()).isEqualTo((float)121.1);


    }
}
