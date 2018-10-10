package pl.project.calculator.exchanger;

import org.springframework.web.client.RestTemplate;

public class NbpExchangeRateDownloader {

    RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }
}
