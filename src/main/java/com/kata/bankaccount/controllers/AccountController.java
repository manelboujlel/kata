package com.kata.bankaccount.controllers;

import com.kata.bankaccount.Exceptions.InsufficientBalanceException;
import com.kata.bankaccount.models.Account;
import com.kata.bankaccount.services.AccountService;
import com.kata.bankaccount.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/bankAccount")
public class AccountController {

    @Autowired
    private IAccountService iAccountService;


    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(@RequestBody Account account, @RequestHeader(name = "amount", required = true) int amount)
            throws Exception {
        iAccountService.deposit(account, amount);
        return new ResponseEntity<String>("Opération réussie", HttpStatus.OK);
    }

    @PostMapping("/withdrawal")
    public ResponseEntity<String> withdrawal(@RequestBody Account account, @RequestHeader(name = "amount", required = true) int amount) {
        try {
            iAccountService.withdrawal(account, amount);
        } catch (InsufficientBalanceException e) {
            return new ResponseEntity<String>("Solde insuffiant", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Opération réussie", HttpStatus.OK);
    }

    @PostMapping("/printStatement")
    public ResponseEntity<String> printStatement(@RequestBody Account account) {
        return new ResponseEntity<String>(iAccountService.printStatement(account).get(), HttpStatus.OK);
    }
}
