package pl.project.calculator.exchanger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.project.calculator.exchanger.calculator.NbpExchangeRateResult;
import pl.project.calculator.exchanger.calculator.NbpExchangeRateSeries;
import pl.project.calculator.exchanger.table.NbpExchangeRateTableSeries;
import pl.project.calculator.exchanger.table.NbpExchangeTableRate;
import pl.project.calculator.exchanger.table.NbpExchangeTableResult;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
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
            if (e.getStatusCode() == HttpStatus.NOT_FOUND && e.getStatusText().contains("Not Found")) {
                return new NbpExchangeRateResult("Client error");
            } else if (e.getStatusCode().equals("404") && e.getStatusText().equals("Not Found")) {
                return new NbpExchangeRateResult("Not Found");
            } else if (e.getStatusCode().equals("400") && e.getStatusText().equals(" Invalid date range")) {
                return new NbpExchangeRateResult("Invalid date range");
            }

        }

        return new NbpExchangeRateResult("Something goes wrong, nobody knows what");
    }

    public NbpExchangeTableResult downloadCurrentCourses(LocalDate exchangeDate) {

        Map<String, String> param = new HashMap<>();
        param.put("date", exchangeDate.toString());

        try {

            ResponseEntity<List<NbpExchangeRateTableSeries>> exchange = restTemplate.exchange("http://api.nbp.pl/api/exchangerates/tables/C/{date}/",
                    HttpMethod.GET, null, new ParameterizedTypeReference<List<NbpExchangeRateTableSeries>>() {
                    }, param);

            List<NbpExchangeTableRate> rates = exchange.getBody().get(0).getRates();
            NbpExchangeTableResult result = new NbpExchangeTableResult(rates, true, null);
            return result;

        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND && e.getStatusText().contains("Not Found")) {
                return new NbpExchangeTableResult("Client error");
            } else if (e.getStatusCode().equals("404") && e.getStatusText().equals("Not Found")) {
                return new NbpExchangeTableResult("Not Found");
            } else if (e.getStatusCode().equals("400") && e.getStatusText().equals(" Invalid date range")) {
                return new NbpExchangeTableResult("Invalid date range");
            }

        }

        return null;
    }


}
