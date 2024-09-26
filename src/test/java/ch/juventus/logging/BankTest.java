package ch.juventus.logging;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BankTest {

    private Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank(100);
    }

    @Test
    void withdraw() {
        // when
        bank.withdraw(50);
        // then
        assertThat(bank.retrieveBalance()).isEqualTo(50);
    }

    @Test
    void withdrawInvalidAmount() {
        // when
        bank.withdraw(200);
        // then
        assertThat(bank.retrieveBalance()).isEqualTo(100);
    }

    @Test
    void deposit() {
        // when
        bank.deposit(50);
        // then
        assertThat(bank.retrieveBalance()).isEqualTo(150);
    }

    @Test
    void retrieveBalance() {
        // when
        double balance = bank.retrieveBalance();
        // then
        assertThat(balance).isEqualTo(100);
    }

}