package pl.project.calculator.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class ExchangeController {

    //przy parzowaniu daty musimy springowi powiedziec o formacie ISO  czyli napisac iso= DateTimeFormat.ISO.DATE

    // albo wysyłąmy wszystkie parametry @PathVariable lub robimy jeden obiekt @RequestBody MyObject object
    //wiec do musi to sami przemyslec


    @GetMapping("/exchange/(value}/{date}"){
         return new ResponseEntity- w taki obiekt mamy opanowac finalny wynik wraz ze statusem httpStatus
     //bo to jest fajny wraper do opanowywania restowych wyników
   }

}
