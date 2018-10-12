package pl.project.calculator.exchanger;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class NbpExchangeRate {

    private String no;
    private LocalDate effectiveDate;
    private BigDecimal mid;


}


