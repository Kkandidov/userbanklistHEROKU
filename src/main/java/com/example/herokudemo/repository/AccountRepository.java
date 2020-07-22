package com.example.herokudemo.repository;

import com.example.herokudemo.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT SUM(a.account) FROM Account a")
    double getAccountsSum();
}
