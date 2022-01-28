package com.kata.bankaccount.services;

import com.kata.bankaccount.Exceptions.AccountNotFoundException;
import com.kata.bankaccount.Exceptions.InsufficientBalanceException;
import com.kata.bankaccount.models.Account;
import com.kata.bankaccount.models.Operation;
import com.kata.bankaccount.models.Deposit;
import com.kata.bankaccount.models.Withdrawal;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class AccountService implements  IAccountService{

    @Override
    public Account deposit(Account account, int amount) throws Exception {
        Deposit deposit = new Deposit(account, amount);
        deposit.execute();
        account.getRegistry().add(deposit);
        return account;
    }

    @Override
    public Account withdrawal(Account account, int amount) throws InsufficientBalanceException, AccountNotFoundException {
        Withdrawal withdrawal = new Withdrawal(account, amount);
        withdrawal.execute();
        account.getRegistry().add(withdrawal);
        return account;
    }

    @Override
    public Optional<String> printStatement(Account account) {
        StringBuilder statement = new StringBuilder("Date                Amount  Balance\n");
        for (Operation op :account.getRegistry()){
            statement.append(op.dateTime.getDayOfMonth()).append("/");
            statement.append(op.dateTime.getMonth()).append("/");
            statement.append(op.dateTime.getYear());
            statement.append("\t");
            if (op.getType().equals("Deposite")){
                statement.append("+");
            }
            else
            if (op.getType().equals("Withdrawal")){
                statement.append("-");
            }
            statement.append(op.amount);
            statement.append("\t");
            statement.append("\n");
        }
        statement.append("                              ").append(account.getBalance());

        return Optional.of(statement.toString());
    }

}
