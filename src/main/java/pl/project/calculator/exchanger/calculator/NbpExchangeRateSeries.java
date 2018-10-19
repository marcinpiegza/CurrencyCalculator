package pl.project.calculator.exchanger.calculator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpExchangeRateSeries {


    public String currency;
    public String code;
    public List<NbpExchangeRate> rates;

}
