package eu.europa.ecb.budgettracker.budgets.repositories;

import eu.europa.ecb.budgettracker.budgets.dtos.Budget;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Builder
@Document(collection = "budgets")
public class BudgetDocument {

    @Id
    private String id;
    private int projectId;
    private BigDecimal amount;

    public static BudgetDocument fromDto(Budget budget, int projectId) {
        return BudgetDocument.builder().projectId(projectId).amount(budget.amount()).build();
    }

    public static Budget toDto(BudgetDocument budgetDocument) {
        return new Budget(budgetDocument.id, budgetDocument.amount);
    }
}
