package pl.project.calculator.exchanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class NbpExchangeRateDownloader {

    @Autowired
    RestTemplate restTemplate ;


    public NbpExchangeRateResult downloadExchangeRate() {

        Map<String, String> params = new HashMap<>();

        NbpExchangeRateResult result = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/{code}/{date}/"
                , NbpExchangeRateResult.class, params);

        // restTemplate.postForObject();

        return result;
    }
}
