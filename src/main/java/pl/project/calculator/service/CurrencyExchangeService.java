package pl.project.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.project.calculator.exchanger.NbpExchangeRateDownloader;
import pl.project.calculator.exchanger.calculator.NbpExchangeRateResult;
import pl.project.calculator.exchanger.table.NbpExchangeTableResult;
import pl.project.calculator.model.ExchangeRequest;
import pl.project.calculator.model.ExchangeResult;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CurrencyExchangeService implements ICurrencyExchangeService {

    private final NbpExchangeRateDownloader nbpExchangeRateDownloader;

    @Autowired
    public CurrencyExchangeService(NbpExchangeRateDownloader nbpExchangeRateDownloader) {
        this.nbpExchangeRateDownloader = nbpExchangeRateDownloader;
    }

    @Override
    public ExchangeResult calculate(ExchangeRequest exchangeRequest) {
        NbpExchangeRateResult nbpExchangeRateResult = nbpExchangeRateDownloader.downloadExchangeRate(exchangeRequest.getCurrency(), exchangeRequest.getDate());
        if (nbpExchangeRateResult.isStatus()) {
            BigDecimal result = exchangeRequest.getValue().divide(nbpExchangeRateResult.getRate(), 2, RoundingMode.HALF_UP);
            return new ExchangeResult(result, null, HttpStatus.OK, nbpExchangeRateResult.getRate());
        }
        return new ExchangeResult(null, nbpExchangeRateResult.getError(), HttpStatus.BAD_REQUEST, null);
    }

    @Override
    public NbpExchangeTableResult calculateRates (ExchangeRequest exchangeRequest){
        NbpExchangeTableResult nbpExchangeTableResult =nbpExchangeRateDownloader.downloadCurrentCourses(exchangeRequest.getDate());
        if(nbpExchangeTableResult.isStatus()){
            nbpExchangeTableResult.getTableRates().forEach(
                    rate -> {
                        rate.setAsk(rate.getAsk().multiply(new BigDecimal(1.05)));
                        rate.setBid(rate.getBid().multiply(new BigDecimal(0.95)));
                    }
            );
           return nbpExchangeTableResult;
        }
        return null;
    }


}
