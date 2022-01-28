package com.kata.bankaccount;


import com.kata.bankaccount.controllers.AccountController;
import com.kata.bankaccount.models.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)



public class AccountControllerTests {

    /*****
     * To be completed
     *****/

    @Autowired
    private TestRestTemplate restTemplate;
    @LocalServerPort
    private int port;
    private String getRootUrl() {
        return "http://localhost:" + port + "/bankAccount";
    }

    @InjectMocks
    AccountController accountController;

    private Account testAccount = new Account("007", 1000);




}
