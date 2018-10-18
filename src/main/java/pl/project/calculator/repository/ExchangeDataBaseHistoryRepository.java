package pl.project.calculator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.project.calculator.model.ExchangeDataBaseHistory;

public interface ExchangeDataBaseHistoryRepository extends JpaRepository<ExchangeDataBaseHistory,Long> {
}
