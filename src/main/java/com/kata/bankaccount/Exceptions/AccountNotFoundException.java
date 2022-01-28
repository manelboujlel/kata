package com.kata.bankaccount.Exceptions;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException() {
        super("Account not found ! ");
    }

}

