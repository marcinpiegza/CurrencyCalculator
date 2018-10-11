package pl.project.calculator.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "exchangeResult")
public enum CurrencyEnum {

    PL,
    EUR,
    CHF,
    USD
}
