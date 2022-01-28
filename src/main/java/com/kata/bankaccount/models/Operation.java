package com.kata.bankaccount.models;

import java.time.LocalDateTime;

public  class Operation   {

    public Account account;
    public float amount;
    public LocalDateTime dateTime;
    public String type;

    public Operation(){

    }
    public Operation(Account account, float amount)
    {
        this.account = account;
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public Account getAccount() {
        return account;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getType() {
        return type;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setType(String type) {
        this.type = type;
    }

    //public abstract int execute() throws InsufficientBalanceException, AccountNotFoundException;

}
