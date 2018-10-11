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

    public ExchangeResult(BigDecimal money, String error, HttpStatus status) {
        this.money = money;
        this.error = error;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ExchangeResult{" +
                "money=" + money +
                ", error='" + error + '\'' +
                ", status=" + status +
                '}';
    }
}
