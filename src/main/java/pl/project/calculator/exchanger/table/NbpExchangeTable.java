package pl.project.calculator.exchanger.table;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class NbpExchangeTable {

        private String currency;
        private LocalDate code;
        private BigDecimal mid;


    }
