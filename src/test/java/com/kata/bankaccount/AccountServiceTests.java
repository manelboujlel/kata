package com.kata.bankaccount;

import com.kata.bankaccount.models.*;
import com.kata.bankaccount.services.AccountService;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountServiceTests {


    @Test
    void deposit() throws Exception {
        AccountService accService = new AccountService();
        Account testAccount = new Account("001",1000);
        accService.deposit(testAccount, 500);
        assertEquals(1500, testAccount.getBalance());
    }

    @Test
    void withDrawal() throws Exception {
        AccountService accService = new AccountService();
        Account testAccount = new Account("001",1000);
        accService.withdrawal(testAccount, 500);
        assertEquals(500, testAccount.getBalance());
    }


    @Test
    void printStatement() {
        AccountService accService = new AccountService();
        Account testAccount = new Account("001",1000);
        List<Operation> testRegistry = new ArrayList<>();
        Operation opr1 = new Deposit(testAccount,600);
        Operation opr2 = new Withdrawal(testAccount,300);
        Operation opr3 = new Withdrawal(testAccount,250);
        testRegistry.add(opr1);
        testRegistry.add(opr2);
        testRegistry.add(opr3);
        testAccount.setRegistry(testRegistry);
        Optional<String> stmt = accService.printStatement(testAccount);
        Assert.assertThat(stmt.toString(), CoreMatchers.containsString("+"));
        Assert.assertThat(stmt.toString(), CoreMatchers.containsString("-"));

    }

}
