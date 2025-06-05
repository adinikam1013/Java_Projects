package com.example.banking.service;

import com.example.banking.repository.BankingRepository;
import org.springframework.stereotype.Service;

@Service
public class BankingService {

    private final BankingRepository bankingRepository;

    public BankingService(BankingRepository bankingRepository) {
        this.bankingRepository = bankingRepository;
    }

    public String deposit(String username, double amount) {
        int result = bankingRepository.deposit(username, amount);
        return result > 0 ? "Deposit successful" : "User not found";
    }

    public String getBalance(String username) {
        double balance = bankingRepository.getBalance(username);
        return "Current balance: ₹" + balance;
    }
}
