package pl.project.calculator.exchanger.table;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
public class NbpExchangeTableResult {


    private List<>
    private boolean status;
    private String error;

    public NbpExchangeRateResult(String error) {
        this.error = error;
    }

    public NbpExchangeRateResult(BigDecimal rate, boolean status, String error) {
        this.rate = rate;
        this.status = status;
        this.error = error;
    }
}
