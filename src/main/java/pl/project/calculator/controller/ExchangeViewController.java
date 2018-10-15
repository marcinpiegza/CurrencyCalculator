package pl.project.calculator.controller;

import javafx.scene.control.Tab;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.project.calculator.model.CurrencyEnum;

@Controller
public class ExchangeViewController {

    @GetMapping("/")
    public String displayMainView(Model model){
        CurrencyEnum[] tab = CurrencyEnum.values();
        //model.
        return "index";
    }


}
