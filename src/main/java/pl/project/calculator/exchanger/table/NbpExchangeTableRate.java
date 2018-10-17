package pl.project.calculator.exchanger.table;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class NbpExchangeTableRate {

    private String currency;
    private String code;
    private BigDecimal bid;
    private BigDecimal ask;

    }
