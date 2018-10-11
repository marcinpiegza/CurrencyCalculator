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


    //przy parzowaniu daty musimy springowi powiedziec o formacie ISO  czyli napisac iso= DateTimeFormat.ISO.DATE

    // albo wysyłąmy wszystkie parametry @PathVariable lub robimy jeden obiekt @RequestBody MyObject object
    //wiec do musi to sami przemyslec

    //to powinno kierowac do serwisu ale  nie wiem czy działa
    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/exchange/(value}/{date}/")
    public ResponseEntity<Class<CurrencyExchangeService>> getExchangeRate(@PathVariable(name = "date")
             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate exchangeDate, BigDecimal value) {


        return new ResponseEntity<>(HttpStatus.OK);
    }
                 //w taki obiekt mamy opanowac finalny wynik wraz ze statusem httpStatus
     //bo to jest fajny wraper do opanowywania restowych wyników
//   }

}
