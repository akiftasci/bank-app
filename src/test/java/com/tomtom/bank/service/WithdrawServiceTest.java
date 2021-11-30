package com.tomtom.bank.service;

import com.tomtom.bank.dto.BalanceDto;
import com.tomtom.bank.dto.BalanceWrapperDto;
import com.tomtom.bank.entity.Account;
import com.tomtom.bank.exception.ApiRequestException;
import com.tomtom.bank.repository.AccountRepository;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WithdrawServiceTest {
    private WithdrawService withdrawServiceMock;
    private AccountRepository accountRepositoryMock;

    @Before
    public void setUp(){
        accountRepositoryMock = mock(AccountRepository.class);
        withdrawServiceMock = new WithdrawService(accountRepositoryMock);
    }

    @Test
    public void testWithdrawal(){
        when(accountRepositoryMock.findById(1L)).thenReturn(createAccount());
        final BalanceWrapperDto withdrawalResponse = withdrawServiceMock.withdrawal(1L, 10);
        final BalanceDto balance = withdrawalResponse.getBalance();

        Assertions.assertThat(balance.getAmount()).isEqualTo(290);
    }

    @Test
    public void testWithdrawalBalanceLowerThanLimit(){
        when(accountRepositoryMock.findById(1L)).thenReturn(createAccountLowerBalance());
        try{
        final BalanceWrapperDto withdrawalResponse = withdrawServiceMock.withdrawal(1L, 10);
        }
        catch (ApiRequestException e){
            Assertions.assertThat(e.getMessage()).isEqualTo("Balance is lower than limit!");
        }

    }

    private Optional<Account> createAccountLowerBalance() {
        final Account account = new Account();
        account.setId(1L);
        account.setName("akif");
        account.setLimits(200);
        account.setBalance(100);
        return Optional.of(account);
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
