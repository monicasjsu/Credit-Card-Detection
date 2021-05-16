package com.monica.creditcard.models;

import static org.junit.Assert.*;

import com.monica.creditcard.parsers.FileParser;
import org.junit.Test;

public class CardInputTest {

  @Test
  public void testValidDate() throws Exception {
    CardInput cardInput = new CardInput(
        "6011123123123123",
        "Monica",
        FileParser.DATE_FORMATTER.parse("25/04/2022")
        );
    assertNotNull(cardInput.getExpirationDate());
  }


  @Test
  public void testEquals() throws Exception {
    CardInput discoverCC1 = new CardInput.Builder()
        .withCardNumber("6011123123123123")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica")
        .build();
    CardInput discoverCC2 = new CardInput.Builder()
        .withCardNumber("6011123123123123")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica")
        .build();

    assertEquals(discoverCC1, discoverCC2);
  }

  @Test
  public void testNotEquals() throws Exception {
    CardInput discoverCC1 = new CardInput.Builder()
        .withCardNumber("6011123123123123")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica")
        .build();
    CardInput discoverCC2 = new CardInput.Builder()
        .withCardNumber("6011123123123123")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica Dommaraju")
        .build();

    assertNotEquals(discoverCC1, discoverCC2);
  }
}