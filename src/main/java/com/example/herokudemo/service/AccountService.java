package com.example.herokudemo.service;

import com.example.herokudemo.exception.EntityNotFoundException;
import com.example.herokudemo.model.Account;

import java.util.List;

public interface AccountService {
    Account add(Account account);
    void delete(long id);
    Account getById(long id) throws EntityNotFoundException;
    Account edit(Account account);
    List<Account> getAll();
    double getAccountsSum();
}

