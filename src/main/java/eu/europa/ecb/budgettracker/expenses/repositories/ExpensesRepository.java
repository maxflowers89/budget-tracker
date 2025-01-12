package eu.europa.ecb.budgettracker.expenses.repositories;

import eu.europa.ecb.budgettracker.expenses.dtos.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface ExpensesRepository extends MongoRepository<ExpenseDocument, String> {
    List<Expense> findByBudgetIdAndDateBetween(String budgetId, LocalDate from, LocalDate to);
}
