package pl.project.calculator.exchanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class NbpExchangeRateDownloader {

    private final RestTemplate restTemplate;

    @Autowired
    public NbpExchangeRateDownloader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public NbpExchangeRateResult downloadExchangeRate(String code, LocalDate exchangeDate) {

        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        params.put("date", exchangeDate.toString());

        NbpExchangeRateSeries result = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/{code}/{date}/"
                ,NbpExchangeRateSeries.class, params);

        //zwraca tez error

        return new NbpExchangeRateResult();
    }
}
