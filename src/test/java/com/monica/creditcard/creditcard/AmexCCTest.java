package com.monica.creditcard.creditcard;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author monica dommaraju
 */
public class AmexCCTest {
    AmexCC amex = new AmexCC();

    @Test
    public void isNotValid() {
        boolean result = amex.isValidCreditCard("32345678910");
        assertFalse(result);
    }

    @Test
    public void isValidAmexNumber() {
        boolean result = amex.isValidCreditCard("342345678915612");
        assertTrue(result);
    }

    @Test
    public void isValidAmexNumber1() {
        boolean result = amex.isValidCreditCard("372345678915612");
        assertTrue(result);
    }

    @Test
    public void isNotValidAmexEmptyString() {
        boolean result = amex.isValidCreditCard("");
        assertFalse(result);
    }

    @Test
    public void isNull() {
        boolean result = amex.isValidCreditCard(null);
        assertFalse(result);
    }

    @Test
    public void isValidAmexWords() {
        boolean result = amex.isValidCreditCard("412aBc56789105");
        assertFalse(result);
    }

    @Test
    public void isnotValidFirstNumber() {
        boolean result = amex.isValidCreditCard("772345678915612");
        assertFalse(result);
    }

    @Test
    public void isnotValidFirstNumberAndLength() {
        boolean result = amex.isValidCreditCard("6123456789156");
        assertFalse(result);
    }

    @Test
    public void isNotValidAmexSpaceString() {
        boolean result = amex.isValidCreditCard(" ");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumberAlphabet() {
        boolean result = amex.isValidCreditCard("A123456789156");
        assertFalse(result);
    }
}
