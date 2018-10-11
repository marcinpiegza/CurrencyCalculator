package pl.project.calculator.exchanger;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class NbpExchangeRate {

    private NbpExchangeRate nbpExchangeRate(String no, String localDate, BigDecimal mid){
        return nbpExchangeRate(no,localDate,mid);
    }



}


