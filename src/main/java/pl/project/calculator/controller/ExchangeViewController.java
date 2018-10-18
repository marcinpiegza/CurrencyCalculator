package pl.project.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.calculator.service.CurrencyExchangeService;

import java.time.LocalDate;

@Controller
public class ExchangeViewController {


    @Autowired
    CurrencyExchangeService currencyExchangeService;

    @GetMapping("/")
    public String displayMainView(Model model){
        model.addAttribute("currencies", currencyExchangeService.calculateRates(LocalDate.now()).getTableRates());

        return "/start";
    }

    @GetMapping("/getRates")
    public String displayAllRatesViev(Model model){
        model.addAttribute("rates", currencyExchangeService.calculateRates(LocalDate.now()).getTableRates());
        return "tableCurrency";
    }
    @GetMapping("/showHistory")
    public String showHistory(Model model){
        model.addAttribute("history",currencyExchangeService.showHistory());
        return "tableExchangeHistory";
    }



}
