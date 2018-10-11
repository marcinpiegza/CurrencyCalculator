package pl.project.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.project.calculator.exchanger.NbpExchangeRateDownloader;
import pl.project.calculator.service.CurrencyExchangeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@RequestMapping("/")
public class ExchangeController {


    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/exchange/{value}/{date}/{code}")
    public ResponseEntity<Class<CurrencyExchangeService>> getExchangeRate(
    @PathVariable(name = "value") BigDecimal value,@PathVariable(name = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exchangeDate,
    @PathVariable(name = "code")String code) {


        return new ResponseEntity<>(HttpStatus.OK);
    }



}
