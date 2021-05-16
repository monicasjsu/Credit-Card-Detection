package com.monica.creditcard.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 * @author monica dommaraju
 */
public class CardInput {
    private String cardNumber;
    private String nameOfCardholder;
    private Date expirationDate;

    @JsonCreator
    public CardInput(
        @JsonProperty("CardNumber") String cardNumber,
        @JsonProperty("NameOfCardholder") String nameOfCardholder,
        @JsonProperty("ExpirationDate") Date expirationDate
    ) {
        this.cardNumber = cardNumber;
        this.nameOfCardholder = nameOfCardholder;
        this.expirationDate = expirationDate;
    }

    public static class Builder {
        private String cardNumber;
        private String nameOfCardholder;
        private Date expirationDate;

        public Builder withCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        public Builder withNameOfCardholder(String nameOfCardholder) {
            this.nameOfCardholder = nameOfCardholder;
            return this;
        }

        public Builder withExpirationDate(Date expirationDate) {
            this.expirationDate = expirationDate;
            return this;
        }

        public CardInput build() {
            return new CardInput(cardNumber, nameOfCardholder, expirationDate);
        }
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getNameOfCardholder() {
        return nameOfCardholder;
    }

    public void setNameOfCardholder(String nameOfCardholder) {
        this.nameOfCardholder = nameOfCardholder;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CardInput cardInput = (CardInput) o;

        if (!cardNumber.equals(cardInput.cardNumber)) {
            return false;
        }
        if (!nameOfCardholder.equals(cardInput.nameOfCardholder)) {
            return false;
        }
        return expirationDate.equals(cardInput.expirationDate);
    }

    @Override
    public int hashCode() {
        int result = cardNumber.hashCode();
        result = 31 * result + nameOfCardholder.hashCode();
        result = 31 * result + expirationDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CardInput{" +
            "cardNumber='" + cardNumber + '\'' +
            ", nameOfCardholder='" + nameOfCardholder + '\'' +
            ", expirationDate=" + expirationDate +
            '}';
    }
}
