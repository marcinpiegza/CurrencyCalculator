package pl.project.calculator.exchanger.table;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class NbpExchangeTableResult {

    private List<NbpExchangeTableRate> tableRates;
    private boolean status;
    private String error;

    public NbpExchangeTableResult() {
    }

    public NbpExchangeTableResult(List<NbpExchangeTableRate> tableRates, boolean status, String error) {
        this.tableRates = tableRates;
        this.status = status;
        this.error = error;
    }

    public NbpExchangeTableResult(String error) {
        this.error = error;
    }
}
