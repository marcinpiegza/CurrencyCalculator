package pl.project.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.calculator.exchanger.NbpExchangeRateDownloader;
import pl.project.calculator.exchanger.NbpExchangeRateResult;

@Service
public class CurrencyExchangeService {

    private final NbpExchangeRateDownloader nbpExchangeRateDownloader;

    @Autowired
    public CurrencyExchangeService(NbpExchangeRateDownloader nbpExchangeRateDownloader) {
        this.nbpExchangeRateDownloader = nbpExchangeRateDownloader;
    }

    private NbpExchangeRateResult calculate() {
        nbpExchangeRateDownloader.downloadExchangeRate();


        return null;
    }


}
