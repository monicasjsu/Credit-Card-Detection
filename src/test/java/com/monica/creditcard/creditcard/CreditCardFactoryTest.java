package com.monica.creditcard.creditcard;

import static org.junit.Assert.*;

import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;
import com.monica.creditcard.parsers.FileParser;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class CreditCardFactoryTest {

  @Test
  public void validateDiscoverCreditCard() throws Exception {
    CardInput discoverCC = new CardInput.Builder()
        .withCardNumber("6011123123123123")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica")
        .build();

    List<CardInput> inputs = new ArrayList<>();
    inputs.add(discoverCC);


    List<CardOutput> output = CreditCardFactory.validateCreditCards(inputs);
    CardOutput expectedCardOutput = new CardOutput.Builder()
        .withCardType("Discover")
        .withNumber("6011123123123123")
        .withError("None")
        .build();
    assertEquals(expectedCardOutput, output.get(0));
  }

  @Test
  public void validateMasterCreditCard() throws Exception {
    CardInput masterCC = new CardInput.Builder()
        .withCardNumber("5211123123123123")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica")
        .build();

    List<CardInput> inputs = new ArrayList<>();
    inputs.add(masterCC);


    List<CardOutput> output = CreditCardFactory.validateCreditCards(inputs);
    CardOutput expectedCardOutput = new CardOutput.Builder()
        .withCardType("MasterCard")
        .withNumber("5211123123123123")
        .withError("None")
        .build();
    assertEquals(expectedCardOutput, output.get(0));
  }

  @Test
  public void validateVisaCreditCard() throws Exception {
    CardInput discoverCC = new CardInput.Builder()
        .withCardNumber("4011123123123123")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica")
        .build();

    List<CardInput> inputs = new ArrayList<>();
    inputs.add(discoverCC);

    List<CardOutput> output = CreditCardFactory.validateCreditCards(inputs);
    CardOutput expectedCardOutput = new CardOutput.Builder()
        .withCardType("Visa")
        .withNumber("4011123123123123")
        .withError("None")
        .build();
    assertEquals(expectedCardOutput, output.get(0));
  }

  @Test
  public void validateAmexCreditCard() throws Exception {
    CardInput discoverCC = new CardInput.Builder()
        .withCardNumber("341112312312312")
        .withExpirationDate(FileParser.DATE_FORMATTER.parse("25/04/2022"))
        .withNameOfCardholder("Monica")
        .build();

    List<CardInput> inputs = new ArrayList<>();
    inputs.add(discoverCC);


    List<CardOutput> output = CreditCardFactory.validateCreditCards(inputs);
    CardOutput expectedCardOutput = new CardOutput.Builder()
        .withCardType("AmericanExpress")
        .withNumber("341112312312312")
        .withError("None")
        .build();
    assertEquals(expectedCardOutput, output.get(0));
  }
}