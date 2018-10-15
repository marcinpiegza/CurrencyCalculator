package pl.project.calculator.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeResult {

    private BigDecimal money;
    private String error;
    private HttpStatus status;
    private BigDecimal rate;

    public ExchangeResult() {
    }

    public ExchangeResult(BigDecimal money, String error, HttpStatus status, BigDecimal rate) {
        this.money = money;
        this.error = error;
        this.status = status;
        this.rate = rate;
    }
}
