package pl.project.calculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import pl.project.calculator.exchanger.NbpExchangeRateDownloader;
import pl.project.calculator.exchanger.calculator.NbpExchangeRateResult;
import pl.project.calculator.exchanger.table.NbpExchangeTableResult;
import pl.project.calculator.model.ExchangeDataBaseHistory;
import pl.project.calculator.model.ExchangeRequest;
import pl.project.calculator.model.ExchangeResult;
import pl.project.calculator.model.User;
import pl.project.calculator.repository.ExchangeDataBaseHistoryRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CurrencyExchangeService implements ICurrencyExchangeService {

    private final NbpExchangeRateDownloader nbpExchangeRateDownloader;
    private final ExchangeDataBaseHistoryRepository exchangeDataBaseHistoryRepository;

    @Autowired
    public CurrencyExchangeService(NbpExchangeRateDownloader nbpExchangeRateDownloader, ExchangeDataBaseHistoryRepository exchangeDataBaseHistoryRepository) {
        this.nbpExchangeRateDownloader = nbpExchangeRateDownloader;
        this.exchangeDataBaseHistoryRepository = exchangeDataBaseHistoryRepository;
    }

    @Override
    public ExchangeResult calculate(ExchangeRequest exchangeRequest) {
        NbpExchangeRateResult nbpExchangeRateResult = nbpExchangeRateDownloader.downloadExchangeRate(exchangeRequest.getCurrency(), exchangeRequest.getDate());
        if (nbpExchangeRateResult.isStatus()) {
            BigDecimal result = exchangeRequest.getValue().divide(nbpExchangeRateResult.getRate(), 2, RoundingMode.HALF_UP);

            ExchangeDataBaseHistory exchangeDataBaseHistory = new ExchangeDataBaseHistory(exchangeRequest.getValue(),exchangeRequest.getCurrency(),exchangeRequest.getDate(),nbpExchangeRateResult.getRate(),result);
            exchangeDataBaseHistoryRepository.save(exchangeDataBaseHistory);

            return new ExchangeResult(result, null, HttpStatus.OK, nbpExchangeRateResult.getRate());
        }
        return new ExchangeResult(null, nbpExchangeRateResult.getError(), HttpStatus.BAD_REQUEST, null);
    }
@Override
    public NbpExchangeTableResult calculateRates (LocalDate date){
        NbpExchangeTableResult nbpExchangeTableResult =nbpExchangeRateDownloader.downloadCurrentCourses(date);
        if(nbpExchangeTableResult.isStatus()){
            nbpExchangeTableResult.getTableRates().forEach(
                    rate -> {
                        rate.setAsk(rate.getAsk().multiply(new BigDecimal(1.05)).setScale(2, RoundingMode.HALF_UP));
                        rate.setBid(rate.getBid().multiply(new BigDecimal(0.95)).setScale(2, RoundingMode.HALF_UP));
                    }
            );
           return nbpExchangeTableResult;
        }
        return null;
    }

    @Override
    public  List<ExchangeDataBaseHistory> showHistory(){
        List<ExchangeDataBaseHistory> lists = new ArrayList<>();
         lists.addAll((exchangeDataBaseHistoryRepository.findAll()));

        return lists;
    }

    @Override
    public User checkUser (String username, String password){
        User user = new User(username,password);
        exchangeDataBaseHistoryRepository.findById(username);
        return
    }





}
