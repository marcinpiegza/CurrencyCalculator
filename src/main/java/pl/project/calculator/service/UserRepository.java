package pl.project.calculator.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.calculator.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

    User finbByUsername(String username);
}
