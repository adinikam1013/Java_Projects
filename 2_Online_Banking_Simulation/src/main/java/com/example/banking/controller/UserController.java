package com.example.banking.controller;

import com.example.banking.service.BankingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final BankingService bankingService;

    public UserController(BankingService bankingService) {
        this.bankingService = bankingService;
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String username, @RequestParam double amount) {
        return bankingService.deposit(username, amount);
    }

    @GetMapping("/balance")
    public String getBalance(@RequestParam String username) {
        return bankingService.getBalance(username);
    }
}
