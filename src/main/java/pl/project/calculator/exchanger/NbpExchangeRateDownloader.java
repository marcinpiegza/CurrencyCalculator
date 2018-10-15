package pl.project.calculator.exchanger;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class NbpExchangeRateDownloader {

    private RestTemplate restTemplate;

    @Autowired
    public NbpExchangeRateDownloader(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    public NbpExchangeRateResult downloadExchangeRate(String code, LocalDate exchangeDate) {

        Map<String, String> params = new HashMap<>();
        params.put("code", code);
        params.put("date", exchangeDate.toString());


        try {
            NbpExchangeRateSeries nbpExchangeRateSeries = restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/{code}/{date}/"
                    , NbpExchangeRateSeries.class, params);

            NbpExchangeRateResult result = new NbpExchangeRateResult(nbpExchangeRateSeries.getRates().get(0).getMid(), true, null);
            return result;

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals("404") && e.getStatusText().contains("Not Found")) {
                NbpExchangeRateResult result = new NbpExchangeRateResult(null, false, "Client error");
                return result;
            } else if (e.getStatusCode().equals("404") && e.getStatusText().equals("Not Found")) {
                NbpExchangeRateResult result = new NbpExchangeRateResult(null, false, "Not Found");
                return result;
            } else if (e.getStatusCode().equals("400") && e.getStatusText().equals(" Invalid date range")) {
                NbpExchangeRateResult result = new NbpExchangeRateResult(null, false, "Invalid date range");
                return result;
            }

        }
    }
}
