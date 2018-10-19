package pl.project.calculator.service;


import pl.project.calculator.exchanger.table.NbpExchangeTableResult;
import pl.project.calculator.model.ExchangeDataBaseHistory;
import pl.project.calculator.model.ExchangeRequest;
import pl.project.calculator.model.ExchangeResult;


import java.time.LocalDate;
import java.util.List;


public interface ICurrencyExchangeService {
    ExchangeResult calculate(ExchangeRequest exchangeRequest);

    NbpExchangeTableResult calculateRates(LocalDate date);

    List<ExchangeDataBaseHistory> showHistory();

}
