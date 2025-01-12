package eu.europa.ecb.budgettracker.expenses.services;

import eu.europa.ecb.budgettracker.expenses.dtos.Expense;
import eu.europa.ecb.budgettracker.expenses.repositories.ExpenseDocument;
import eu.europa.ecb.budgettracker.expenses.repositories.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpensesService {

    private final ExpensesRepository expensesRepository;

    public List<Expense> findByBudgetIdAndDateBetween(String budgetId, LocalDate from, LocalDate to) {
        return expensesRepository.findByBudgetIdAndDateBetween(budgetId, from, to);
    }

    public List<Expense> saveAll(String budgetId, List<Expense> expenses) {
        return expensesRepository
                .saveAll(expenses.stream().map(e -> ExpenseDocument.fromDto(e, budgetId)).toList())
                .stream()
                .map(ExpenseDocument::toDto)
                .toList();
    }

    public Expense save(String budgetId, String expenseId, Expense expense) {
        final var expenseDocument = ExpenseDocument.fromDto(expense, budgetId).withId(expenseId);
        return ExpenseDocument.toDto(expensesRepository.save(expenseDocument));
    }
}
