package com.monica.creditcard.creditcard;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author monica dommaraju
 */
public class VisaCCTest {
    VisaCC visa = new VisaCC();

    @Test
    public void isNotValid() {
        boolean result = visa.isValidCreditCard("412345678910");
        assertFalse(result);
    }

    @Test
    public void isValidVisaNum() {
        boolean result = visa.isValidCreditCard("4123456789156");
        assertTrue(result);
    }

    @Test
    public void isValidVisaNumber() {
        boolean result = visa.isValidCreditCard("4123456789156123");
        assertTrue(result);
    }

    @Test
    public void isNotValidVisaString() {
        boolean result = visa.isValidCreditCard("");
        assertFalse(result);
    }

    @Test
    public void isNull() {
        boolean result = visa.isValidCreditCard(null);
        assertFalse(result);
    }

    @Test
    public void isValidVisaWords() {
        boolean result = visa.isValidCreditCard("412aBc567891056");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumber() {
        boolean result = visa.isValidCreditCard("51267891056");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumberAndLength() {
        boolean result = visa.isValidCreditCard("6123456789156");
        assertFalse(result);
    }

    @Test
    public void isNotValidVisaEmptyString() {
        boolean result = visa.isValidCreditCard(" ");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumberAlphabet() {
        boolean result = visa.isValidCreditCard("A123456789156");
        assertFalse(result);
    }
}