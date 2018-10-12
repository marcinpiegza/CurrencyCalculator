package pl.project.calculator.exchanger;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class NbpExchangeRate {


    private String no;
    private String localDate;
    private BigDecimal mid;

    public NbpExchangeRate(String no, String localDate, BigDecimal mid) {
        this.no = no;
        this.localDate = localDate;
        this.mid = mid;
    }
}


