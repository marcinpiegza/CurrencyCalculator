package pl.project.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @GetMapping("/showHistory")
    public String showHistory(Model model){
        model.addAttribute("history",currencyExchangeService.showHistory());
        return "tableExchangeHistory";
    }

//    @GetMapping("/")
//        public String firstPage(){
//        return "firstPage";
//    }

    @GetMapping("/register")
    public String registrationPage(){
        return "register";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }




}
