package com.example.banking.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BankingRepository {

    private final JdbcTemplate jdbcTemplate;

    public BankingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int deposit(String username, double amount) {
        return jdbcTemplate.update(
            "UPDATE accounts SET balance = balance + ? WHERE user_id = (SELECT id FROM users WHERE username = ?)",
            amount, username);
    }

    public double getBalance(String username) {
        return jdbcTemplate.queryForObject(
            "SELECT balance FROM accounts WHERE user_id = (SELECT id FROM users WHERE username = ?)",
            Double.class, username);
    }
}
