package pl.project.calculator.service;


import pl.project.calculator.model.ExchangeRequest;
import pl.project.calculator.model.ExchangeResult;

public interface ICurrencyExchangeService {
     ExchangeResult calculate(ExchangeRequest exchangeRequest);


}
