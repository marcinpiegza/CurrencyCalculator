package pl.project.calculator.exchanger.table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import pl.project.calculator.exchanger.calculator.NbpExchangeRate;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown =true)
public class NbpCurrencies {

    public String currency;
    public String code;
    public List<NbpExchangeTable> rates;

    public NbpCurrencies(String currency, String code, List<NbpExchangeTable> rates) {
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }
}
