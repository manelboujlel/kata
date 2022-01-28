package com.kata.bankaccount.models;


public class Deposit extends Operation {

    public Deposit(Account account, float amount)
    {
        super(account, amount);
        this.type = "Deposite";
    }

    //@Override
    public float execute() {
        account.setBalance(account.getBalance() + amount);
        return account.getBalance();
    }






}
