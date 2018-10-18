package pl.project.calculator.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter

public class ExchangeDataBaseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal value;

    private String currency;

    private LocalDate date;

    private BigDecimal rate;

    private BigDecimal exchangeValue;

    public ExchangeDataBaseHistory() {
    }

    public ExchangeDataBaseHistory(BigDecimal value, String currency, LocalDate date, BigDecimal rate, BigDecimal exchangeValue) {
        this.value = value;
        this.currency = currency;
        this.date = date;
        this.rate = rate;
        this.exchangeValue = exchangeValue;
    }
}
