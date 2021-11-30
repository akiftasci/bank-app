package com.tomtom.bank.service;

import com.tomtom.bank.entity.Account;
import com.tomtom.bank.repository.AccountRepository;
import java.time.LocalDateTime;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {
    private final String desiredFormat = "12-11-2021 19:02";
    private AccountService accountServiceMock;
    private AccountRepository accountRepositoryMock;


    @Before
    public void setUp() throws Exception{
        accountRepositoryMock = mock(AccountRepository.class);
        accountServiceMock = new AccountService(accountRepositoryMock);
    }

    @Test
    public void testPersistAccount(){
        final Account account = createAccountEntity();

        when(accountRepositoryMock.save(account)).thenReturn(createPersistedEntity());

        final Account result = accountServiceMock.persistAccount(account);

        Assertions.assertThat(result.getName()).isEqualTo(account.getName());
        Assertions.assertThat(result.getCreated()).isEqualTo(LocalDateTime.of(2021, 11, 12, 19, 2));
        Assertions.assertThat(result.getLimits()).isEqualTo(account.getLimits());
        Assertions.assertThat(result.getId()).isEqualTo(1L);
    }

    private Account createPersistedEntity() {
        final Account account = new Account();
        account.setId(1L);
        account.setName("akif");
        account.setLimits((float) 1.2);
        account.setCreated(LocalDateTime.of(2021, 11, 12, 19, 2));
        return account;
    }

    private Account createAccountEntity() {
        final Account account = new Account();
        account.setName("akif");
        account.setLimits((float) 1.2);
        return account;
    }


}
