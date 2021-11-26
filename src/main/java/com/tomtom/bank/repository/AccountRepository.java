package com.tomtom.bank.repository;

import com.tomtom.bank.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
