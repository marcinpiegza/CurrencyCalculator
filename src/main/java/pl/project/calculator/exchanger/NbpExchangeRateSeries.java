package pl.project.calculator.exchanger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown =true)
public class NbpExchangeRateSeries {


    public String currency;
    public String code;
    public List<NbpExchangeRate> rates;

//    public NbpExchangeRateSeries(String currency, String code, List<NbpExchangeRate> rates) {
//        this.currency = currency;
//        this.code = code;
//        this.rates = rates;
//    }

    @Override
    public String toString() {
        return "NbpExchangeRateSeries{" +
                "currency='" + currency + '\'' +
                ", Code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }


}
