package com.tomtom.bank.service;

import com.tomtom.bank.dto.BalanceDto;
import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepositServiceTest {
    private DepositService depositServiceMock;
    private AccountRepository accountRepositoryMock;

    @Before
    public void setUp(){
        accountRepositoryMock = mock(AccountRepository.class);
        depositServiceMock = new DepositService(accountRepositoryMock);
    }

    @Test
    public void testWithdrawal(){
        when(accountRepositoryMock.findById(1L)).thenReturn(createAccount());
        final BalanceWrapperDto withdrawalResponse = depositServiceMock.deposit(1L, 10);
        final BalanceDto balance = withdrawalResponse.getBalance();

        Assertions.assertThat(balance.getAmount()).isEqualTo(310);
    }
    private Optional<Account> createAccount() {
        final Account account = new Account();
        account.setId(1L);
        account.setName("akif");
        account.setLimits(200);
        account.setBalance(300);
        return Optional.of(account);
    }
}
