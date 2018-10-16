package pl.project.calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class ExchangeViewController {

    @GetMapping("/")
    public String displayMainView(Model model){
        model.addAttribute("currencies", new ArrayList<>());
        return "index";
    }


}
