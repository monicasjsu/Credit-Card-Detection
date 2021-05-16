package com.monica.creditcard.creditcard;

import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;

/**
 * @author monica dommaraju
 */
public class AmexCC extends CreditCard {
    private final static String AMEX = "AmericanExpress";

    private CreditCard successor = null;

    public boolean isValid(String number) {
        if (number == null || number.length() != 15)
            return false;
        char[] ch = number.toCharArray();
        int secondNumber = Character.getNumericValue(ch[1]);
        return (ch[0] == '3' && (secondNumber == 4 || secondNumber == 7));
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
                .withCardType(AMEX)
                .withError(NONE)
                .build();
        } else {
            return successor.getOutput(input);
        }
    }
}
