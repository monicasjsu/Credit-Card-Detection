package com.monica.creditcard.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardOutputTest {

  @Test
  public void testEquals() {
    CardOutput discover1 = new CardOutput.Builder()
        .withCardType("Discover")
        .withNumber("6011123123123123")
        .withError("None")
        .build();

    CardOutput discover2 = new CardOutput.Builder()
        .withCardType("Discover")
        .withNumber("6011123123123123")
        .withError("None")
        .build();

    assertEquals(discover1, discover2);
  }

  @Test
  public void testNotEquals() {
    CardOutput discover1 = new CardOutput.Builder()
        .withCardType("Discover")
        .withNumber("6011123123123123")
        .withError("None")
        .build();

    CardOutput discover2 = new CardOutput.Builder()
        .withCardType("Discovery")
        .withNumber("6011123123123123")
        .withError("None")
        .build();

    assertNotEquals(discover1, discover2);
  }
}