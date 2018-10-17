package pl.project.calculator.exchanger.table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class NbpExchangeRateTableSeries {

    private LocalDate effectiveDate;
    private List<NbpExchangeTableRate> rates;
}
