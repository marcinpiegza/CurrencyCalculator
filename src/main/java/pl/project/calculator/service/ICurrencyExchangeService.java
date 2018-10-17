package pl.project.calculator.service;


import pl.project.calculator.exchanger.table.NbpExchangeTableResult;
import pl.project.calculator.model.ExchangeRequest;
import pl.project.calculator.model.ExchangeResult;


public interface ICurrencyExchangeService {
     ExchangeResult calculate(ExchangeRequest exchangeRequest);
     NbpExchangeTableResult calculateRates (ExchangeRequest exchangeRequest);


}
