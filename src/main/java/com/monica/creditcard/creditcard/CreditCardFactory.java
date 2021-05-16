package com.monica.creditcard.creditcard;

import com.monica.creditcard.models.CardInput;
import com.monica.creditcard.models.CardOutput;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author monica dommaraju
 */
public class CreditCardFactory {
    protected static CreditCard ccChainStart = getCreditCardChain();

    private static CreditCard getCreditCardChain() {
        ccChainStart = new VisaCC();
        ccChainStart
            .setSuccessor(new MasterCC())
            .setSuccessor(new AmexCC())
            .setSuccessor(new DiscoverCC());

        return ccChainStart;
    }

    public static List<CardOutput> validateCreditCards(List<CardInput> cardInputs) {
        return cardInputs.stream()
            .map(cardInput -> ccChainStart.getOutput(cardInput))
            .collect(Collectors.toList());
    }

}
