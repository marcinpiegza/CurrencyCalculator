package pl.project.calculator.model;

import javafx.util.converter.BigDecimalStringConverter;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Currency {

    private String currency;

    private  String Code;

    private String rates;


    private  String  no;

    private  String effectiveDate;

            private BigDecimal mid;
}
