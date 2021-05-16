package com.monica.creditcard.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author monica dommaraju
 */
public class CardOutput {
    @JsonProperty("CardNumber")
    private String number;
    @JsonProperty("CardType")
    private String cardType;
    @JsonProperty("Error")
    private String error;

    @JsonCreator
    public CardOutput(
        @JsonProperty("CardNumber") String number,
        @JsonProperty("CardType") String cardType,
        @JsonProperty("Error") String error
    ) {
        this.number = number;
        this.cardType = cardType;
        this.error = error;
    }

    public static class Builder {
        private String number;
        private String cardType;
        private String error;

        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder withCardType(String cardType) {
            this.cardType = cardType;
            return this;
        }

        public Builder withError(String error) {
            this.error = error;
            return this;
        }

        public CardOutput build() {
            return new CardOutput(number, cardType, error);
        }
    }


    public String getNumber() {

        return number;
    }

    public String getCardType() {

        return cardType;
    }

    public String getError() {
        return error;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CardOutput that = (CardOutput) o;

        if (!number.equals(that.number)) {
            return false;
        }
        if (!cardType.equals(that.cardType)) {
            return false;
        }
        return error.equals(that.error);
    }

    @Override
    public int hashCode() {
        int result = number.hashCode();
        result = 31 * result + cardType.hashCode();
        result = 31 * result + error.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CardOutput{" +
            "number='" + number + '\'' +
            ", cardType='" + cardType + '\'' +
            ", error='" + error + '\'' +
            '}';
    }
}
