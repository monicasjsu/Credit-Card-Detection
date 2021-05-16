package com.monica.creditcard.creditcard;

import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;

/**
 * @author monica dommaraju
 */
public class VisaCC extends CreditCard {
    private final static String VISA = "Visa";
    private CreditCard successor;

    public boolean isValid(String number) {
        if (number == null)
            return false;
        int len = number.length();
        return (len == 13 || len == 16) && number.charAt(0) == '4';
    }

    @Override
    public CreditCard setSuccessor(CreditCard next) {
        this.successor = next;
        return next;
    }

    @Override
    public CardOutput getOutput(CardInput input) {
        boolean isValid = isValidCreditCard(input.getCardNumber());
        if(isValid) {
            return new CardOutput.Builder()
                .withNumber(input.getCardNumber())
                .withCardType(VISA)
                .withError(NONE)
                .build();
        } else {
            return successor.getOutput(input);
        }
    }
}
