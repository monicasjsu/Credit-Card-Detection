package com.monica.creditcard.creditcard;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreditCardTest {
  private CreditCard card = new VisaCC();

  @Test
  public void isValidCreditCard() {
   assertTrue(card.isValidCreditCard("4011123123123123"));
  }

  @Test
  public void isValidCreditCardWithSpaces() {
    assertTrue(card.isValidCreditCard(" 4011 1231 2312 3123 "));
  }

  @Test
  public void isValidCreditCardWithExp() {
    assertTrue(card.isValidCreditCard(" 4.12E+ 12"));
  }

  @Test
  public void isInValidCreditCardLenGreaterThan19() {
    assertFalse(card.isValidCreditCard("40111231231231231234"));
  }

  @Test
  public void isInValidCreditCardHasChars() {
    assertFalse(card.isValidCreditCard("4011123abc123123"));
  }
}