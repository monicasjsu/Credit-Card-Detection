package com.monica.creditcard.creditcard;

import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;

/**
 * @author monica dommaraju
 */
public class MasterCC extends CreditCard {
    private final static String MASTER = "MasterCard";
    private CreditCard successor;

    public boolean isValid(String number) {
        if(number == null || number.length() != 16) {
            return false;
        }
        int len = number.length();
        char[] ch = number.toCharArray();
        int secondNumber = Character.getNumericValue(ch[1]);
        return (ch[0] == '5' && (secondNumber >= 1 && secondNumber <= 5));
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
                .withCardType(MASTER)
                .withError(NONE)
                .build();
        } else {
            return successor.getOutput(input);
        }
    }
}
