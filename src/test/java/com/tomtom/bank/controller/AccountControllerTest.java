package com.tomtom.bank.controller;

import com.tomtom.bank.dto.AccountDto;
import com.tomtom.bank.dto.AccountWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import com.tomtom.bank.service.AccountService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountControllerTest {
    private AccountController accountControllerMock;
    private AccountRepository accountRepositoryMock;
    private AccountService accountServiceMock;

    @Before
    public void setUp() {
        accountRepositoryMock = mock(AccountRepository.class);
        accountServiceMock = mock(AccountService.class);
        accountControllerMock = new AccountController(accountServiceMock);
    }

    @Test
    public void testGetAccount() {
        when(accountServiceMock.getAccount(1L)).thenReturn(createAccountEntity());
        final AccountWrapperDto response = accountControllerMock.getAccountById(1L);
        final AccountDto accountDto = new AccountDto();
        accountDto.setId(1L);
        accountDto.setName("akif");
        accountDto.setLimits((float)1.2);
        Assertions.assertThat(response.getAccount()).isEqualTo(accountDto);
    }
    private Account createAccountEntity() {
        final Account account = new Account();
        account.setName("akif");
        account.setLimits((float) 1.2);
        return account;
    }

}
