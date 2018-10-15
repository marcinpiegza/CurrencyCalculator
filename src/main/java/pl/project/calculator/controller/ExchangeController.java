package pl.project.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.project.calculator.model.ExchangeRequest;
import pl.project.calculator.model.ExchangeResult;
import pl.project.calculator.service.CurrencyExchangeService;

import java.math.BigDecimal;
import java.time.LocalDate;


@RestController
public class ExchangeController {


    //przy parzowaniu daty musimy springowi powiedziec o formacie ISO  czyli napisac iso= DateTimeFormat.ISO.DATE

    // albo wysyłąmy wszystkie parametry @PathVariable lub robimy jeden obiekt @RequestBody MyObject object
    //wiec do musi to sami przemyslec

    //to powinno kierowac do serwisu ale  nie wiem czy działa
    private final CurrencyExchangeService currencyExchangeService;

    @Autowired
    public ExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @PostMapping("/exchange")
    public ResponseEntity<ExchangeResult> getExchangeRate(@RequestBody ExchangeRequest exchangeRequest) {


//      1. odbieramy wartosci (value, date i currency)   gotowe
//        2. wstrzykujemy w exchnge controller service bo chcemy je przekazac do servisu gotowe
//            3. w currency exahange service wstrzykujemy nbp exchange downoloader gotowe

        ExchangeResult result = currencyExchangeService.calculate(exchangeRequest);


//                4. do nbp exchange downoloaderprzekazujemy date i walute(wartosci nie bo jąliczymy w serwisie)
//        5. w nbp exchange downoloader wstzukyjemy rest tempplate
//                6. majac wynik wracamy do currency exchange servise(typem zwracamyn bedzie obiekt ktory bedzie zawierał rating i error message(typ string))
//            i w momencie jak nie bedzie błedu uzupełniamy rating lub error , dodac boolena ktory nam powie czy jest ok czy nie
//                jak jest ok to wyciagamy stawke rate i dzielimy ją
//               7. nastepnie mamy wynik


        return new ResponseEntity<>(result, result.getStatus());
    }
    //w taki obiekt mamy opanowac finalny wynik wraz ze statusem httpStatus
    //bo to jest fajny wraper do opanowywania restowych wyników
//   }

}
