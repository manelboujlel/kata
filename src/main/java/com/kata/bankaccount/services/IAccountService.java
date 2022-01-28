package com.kata.bankaccount.services;

import com.kata.bankaccount.Exceptions.AccountNotFoundException;
import com.kata.bankaccount.Exceptions.InsufficientBalanceException;
import com.kata.bankaccount.models.Account;

import java.util.Optional;

public interface IAccountService {
    public Account deposit(Account account, int amount) throws Exception;
    public Account withdrawal(Account account, int amount) throws InsufficientBalanceException, AccountNotFoundException;
    public Optional<String> printStatement(Account account);


}
