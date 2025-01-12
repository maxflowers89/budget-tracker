package eu.europa.ecb.budgettracker.expenses.repositories;

import eu.europa.ecb.budgettracker.expenses.dtos.Expense;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpensesRepository extends MongoRepository<ExpenseDocument, String> {
  List<Expense> findByBudgetIdAndDateBetween(String budgetId, LocalDate from, LocalDate to);
}
