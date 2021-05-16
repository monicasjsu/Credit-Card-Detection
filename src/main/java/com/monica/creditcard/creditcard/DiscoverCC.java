package com.monica.creditcard.creditcard;

import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;

/**
 * @author monica dommaraju
 */
public class DiscoverCC extends CreditCard{
    private final static String DISCOVER = "Discover";
    private CreditCard successor;

    public boolean isValid(String number) {
        if (number == null || number.length() != 16)
            return false;
        String firstFourNums = number.substring(0, 4);
        return firstFourNums.equals("6011");
    }

    @Override
    public CreditCard setSuccessor(CreditCard next) {
        this.successor = next;
        return next;
    }

    @Override
    public CardOutput getOutput(CardInput input) {
        boolean isValid = isValidCreditCard(input.getCardNumber());
        CardOutput.Builder outputBldr = new CardOutput.Builder()
            .withNumber(input.getCardNumber());
        if(isValid) {
            outputBldr
                .withCardType(DISCOVER)
                .withError(NONE);
        } else {
            outputBldr
                .withCardType(INVALID)
                .withError(INVALID_CARD_NUM);
        }
        return outputBldr.build();
    }
}
