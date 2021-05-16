package com.monica.creditcard.creditcard;

import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;

/**
 * @author monica dommaraju
 */
public abstract class CreditCard {
    protected final static String NONE = "None";
    protected final static String INVALID = "Invalid";
    protected final static String INVALID_CARD_NUM = "InvalidCardNumber";

    protected abstract boolean isValid(String number);
    public abstract CreditCard setSuccessor(CreditCard next);
    public abstract CardOutput getOutput(CardInput input);

    protected boolean isValidCreditCard(String rawCreditCardNum) {
        try {
            rawCreditCardNum = rawCreditCardNum.replaceAll("\\s","");
            String parsedCardNumber = String.valueOf(Double.valueOf(rawCreditCardNum).longValue());
            return parsedCardNumber.length() <= 19 && parsedCardNumber.matches("[0-9]+") && isValid(parsedCardNumber);
        } catch (Exception ex) {
            System.out.println("Invalid credit card number");
            return false;
        }
    }
}