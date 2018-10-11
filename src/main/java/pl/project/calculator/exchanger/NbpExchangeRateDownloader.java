package pl.project.calculator.exchanger;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.project.calculator.model.Currency;

@Component
public class NbpExchangeRateDownloader {

    RestTemplate restTemplate = new RestTemplate();

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public String downloadExchangeRate (){
        restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/{code}/{date}/", NbpExchangeRateSeries.class );

return "";
    }
}
