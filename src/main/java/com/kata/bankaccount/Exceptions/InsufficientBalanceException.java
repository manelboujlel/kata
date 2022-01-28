package com.kata.bankaccount.Exceptions;

    public class InsufficientBalanceException extends RuntimeException {

        public InsufficientBalanceException() {
            super("Insufficient Balance ! ");
        }
    }

