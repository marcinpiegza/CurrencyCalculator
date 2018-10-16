package pl.project.calculator.exchanger;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown =true)
public class NbpCurrencies {

    public String currency;
    public String code;
    public List<NbpExchangeRate> rates;

}
