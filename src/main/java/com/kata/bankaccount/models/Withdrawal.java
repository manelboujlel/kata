package com.kata.bankaccount.models;


import com.kata.bankaccount.Exceptions.AccountNotFoundException;
import com.kata.bankaccount.Exceptions.InsufficientBalanceException;

public class Withdrawal extends Operation  {

    public Withdrawal(Account account, int amount)
    {
        super(account, amount);
        this.type = "Withdrawal";

    }

    //@Override
    public float execute() throws InsufficientBalanceException, AccountNotFoundException {

        if (account != null) {
            if (amount > account.getBalance()) {
                throw new InsufficientBalanceException();
            }
            account.setBalance(account.getBalance()-amount);
            return account.getBalance();
        }

         throw new AccountNotFoundException();


    }
}
