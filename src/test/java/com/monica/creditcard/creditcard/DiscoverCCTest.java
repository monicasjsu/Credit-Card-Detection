package com.monica.creditcard.creditcard;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author monica dommaraju
 */
public class DiscoverCCTest {
    DiscoverCC discover = new DiscoverCC();

    @Test
    public void isNotValid() {
        boolean result = discover.isValidCreditCard("342345679156121");
        assertFalse(result);
    }

    @Test
    public void isValidDiscoverNumber() {
        boolean result = discover.isValidCreditCard("6011345678915612");
        assertTrue(result);
    }


    @Test
    public void isNotValidDiscoverEmptyString() {
        boolean result = discover.isValidCreditCard("");
        assertFalse(result);
    }

    @Test
    public void isNull() {
        boolean result = discover.isValidCreditCard(null);
        assertFalse(result);
    }

    @Test
    public void isNotValidDiscoverWords() {
        boolean result = discover.isValidCreditCard("60114aBc56789105");
        assertFalse(result);
    }


    @Test
    public void isNotValidFirstNumberAndLength() {
        boolean result = discover.isValidCreditCard("6123456789156");
        assertFalse(result);
    }

    @Test
    public void isNotValidDiscoverSpaceString() {
        boolean result = discover.isValidCreditCard(" ");
        assertFalse(result);
    }

    @Test
    public void isValidFirstNumberAlphabet() {
        boolean result = discover.isValidCreditCard("A123456789156");
        assertFalse(result);
    }
}
