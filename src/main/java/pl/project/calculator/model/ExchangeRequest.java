package pl.project.calculator.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExchangeRequest {

    private BigDecimal vaule;
    private LocalDate exchangeDate;
    private String currency;

    public BigDecimal getVaule() {
        return vaule;
    }

    public void setVaule(BigDecimal vaule) {
        this.vaule = vaule;
    }

    public LocalDate getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(LocalDate exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
