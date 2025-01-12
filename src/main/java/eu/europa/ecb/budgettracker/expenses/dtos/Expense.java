package eu.europa.ecb.budgettracker.expenses.dtos;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public record Expense(String id,
                      @NotNull BigDecimal amount,
                      @NotNull LocalDate date,
                      String category) {

}
