package pl.project.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.calculator.service.CurrencyExchangeService;

import java.util.ArrayList;

@Controller
public class ExchangeViewController {

    @Autowired
    CurrencyExchangeService currencyExchangeService;
    @GetMapping("/")
    public String displayMainView(Model model){
        model.addAttribute("currencies", new ArrayList<>());

        return "index";
    }

    @GetMapping("/getRates")
    public String displayAllRatesViev(Model model){
        model.addAttribute("rates", currencyExchangeService.calculate());
        return "tableCurrency";
    }



}
