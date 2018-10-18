package pl.project.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.calculator.service.CurrencyExchangeService;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class ExchangeViewController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;
    @GetMapping("/")
    public String displayMainView(Model model){
        model.addAttribute("currencies", currencyExchangeService.calculateRates(LocalDate.now()).getTableRates());

        return "index";
    }

    @GetMapping("/getRates")
    public String displayAllRatesViev(Model model){
        model.addAttribute("rates", currencyExchangeService.calculateRates(LocalDate.now()).getTableRates());
        return "tableCurrency";
    }



}
