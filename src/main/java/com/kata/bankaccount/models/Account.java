package com.kata.bankaccount.models;


import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountId;
    private float balance;
    private List<Operation> registry;


    public Account(String accountId, int balance)
    {
        this.accountId = accountId;
        this.balance = balance;
        this.registry = new ArrayList<Operation>();
    }

    public String getAccountId() {
        return accountId;
    }

    public float getBalance() {
        return balance;
    }

    public List<Operation> getRegistry() {
        return registry;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setRegistry(List<Operation> registry) {
        this.registry = registry;
    }
}
