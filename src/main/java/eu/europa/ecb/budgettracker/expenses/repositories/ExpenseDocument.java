package eu.europa.ecb.budgettracker.expenses.repositories;

import eu.europa.ecb.budgettracker.expenses.dtos.Expense;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder(toBuilder = true)
@Document(collection = "expenses")
public class ExpenseDocument {

    @Id
    private String id;
    private String budgetId;
    private BigDecimal amount;
    private LocalDate date;
    private String category;

    public static ExpenseDocument fromDto(Expense expense, String budgetId) {
        return ExpenseDocument.builder()
                .budgetId(budgetId)
                .amount(expense.amount())
                .date(expense.date())
                .category(expense.category())
                .build();
    }

    public ExpenseDocument withId(String id) {
        return toBuilder().id(id).build();
    }

    public static Expense toDto(ExpenseDocument expenseDocument) {
        return new Expense(
                expenseDocument.id,
                expenseDocument.amount,
                expenseDocument.date,
                expenseDocument.category);
    }
}
