package ch.juventus.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bank {

    final Logger logger = LoggerFactory.getLogger(Bank.class);

    private double balance;

    public Bank() {
        logger.info("Bank created with initial balance 0");
    }

    public Bank(double balance) {
        logger.info("Bank created with initial balance {}", balance);
        this.balance = balance;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            logger.info("Withdraw {}. New balance is {}", amount, balance);
        } else {
            logger.warn("Balance too low! Failed to withdraw {}. Available amount: {}", amount, balance);
        }
    }

    public void deposit(double amount) {
        balance = balance + amount;
        logger.info("Deposit {}. New balance is {}", amount, balance);
    }

    public double retrieveBalance() {
        logger.debug("Current balance is {}", balance);
        return balance;
    }

}
