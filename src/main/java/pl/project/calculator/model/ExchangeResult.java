package pl.project.calculator.model;

import org.springframework.http.HttpStatus;

import java.math.BigDecimal;

public class ExchangeResult {

    private BigDecimal money;
    private String error;
    private HttpStatus status;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

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
