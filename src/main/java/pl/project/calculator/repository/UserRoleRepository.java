package pl.project.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.calculator.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, String> {

   UserRole findByRole(String role);
}
