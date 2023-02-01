package edu.miu.cs.cs425.fairfieldlibraryapp.model;


import jakarta.persistence.Embeddable;

@Embeddable
public final class  Money implements ValueObject {
    private  Double amount;
    private String currencyCode ; //USD ,GBP ,EUR  etc.


    public Money() {

        this(null,null) ;
    }

    public Money(Double amount, String currencyCode) {
        this.amount = amount;
        this.currencyCode = currencyCode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }



}
