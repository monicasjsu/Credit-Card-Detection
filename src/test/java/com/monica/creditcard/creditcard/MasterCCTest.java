package com.monica.creditcard.creditcard;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author monica dommaraju
 */
public class MasterCCTest {
    MasterCC master = new MasterCC();

    @Test
    public void isNotValidLength() {
        boolean result = master.isValidCreditCard("412345678910123");
        assertFalse(result);
    }

    @Test
    public void isValidMasterNum() {
        boolean result = master.isValidCreditCard("5234567891234567");
        assertTrue(result);
    }

    @Test
    public void isValidNum() {
        boolean result = master.isValidCreditCard("5323456789156767");
        assertTrue(result);
    }

    @Test
    public void isValidNumber() {
        boolean result = master.isValidCreditCard("5623456789156767");
        assertFalse(result);
    }

    @Test
    public void isValidMasterSecondNum() {
        boolean result = master.isValidCreditCard("5123456789156767");
        assertTrue(result);
    }

    @Test
    public void isValidMasterNumber() {
        boolean result = master.isValidCreditCard("5623456789156123");
        assertFalse(result);
    }

    @Test
    public void isNotValidMasterString() {
        boolean result = master.isValidCreditCard("");
        assertFalse(result);
    }

    @Test
    public void isNull() {
        boolean result = master.isValidCreditCard(null);
        assertFalse(result);
    }

    @Test
    public void isValidVisaWords() {
        boolean result = master.isValidCreditCard("412aBc567891056");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumber() {
        boolean result = master.isValidCreditCard("51267891056");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumberAndLength() {
        boolean result = master.isValidCreditCard("6123456789156");
        assertFalse(result);
    }

    @Test
    public void isNotValidMasterEmptyString() {
        boolean result = master.isValidCreditCard(" ");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumberAlphabet() {
        boolean result = master.isValidCreditCard("A123456789156");
        assertFalse(result);
    }
}
