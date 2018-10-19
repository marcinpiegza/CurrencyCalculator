package pl.project.calculator.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Getter
@Setter
public class UserRole {

    @Id
    private Long id;
    private String role;
}
