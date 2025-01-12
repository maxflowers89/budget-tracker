package eu.europa.ecb.budgettracker.expenses.apis;

import eu.europa.ecb.budgettracker.expenses.dtos.Expense;
import eu.europa.ecb.budgettracker.expenses.services.ExpensesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    @GetMapping
    public ResponseEntity<List<Expense>> findByDateBetween(
            @RequestParam String budgetId,
            @RequestParam LocalDate from,
            @RequestParam LocalDate to) {
        return ResponseEntity.ok(expensesService.findByBudgetIdAndDateBetween(budgetId, from, to));
    }

    @PostMapping
    public ResponseEntity<List<Expense>> saveAll(
            @RequestParam String budgetId,
            @Valid @RequestBody List<Expense> expenses) {
        return ResponseEntity.ok(expensesService.saveAll(budgetId, expenses));
    }

    @PutMapping("/{expenseId}")
    public ResponseEntity<Expense> save(
            @RequestParam String budgetId,
            @PathVariable String expenseId,
            @Valid @RequestBody Expense expense) {
        return ResponseEntity.ok(expensesService.save(budgetId, expenseId, expense));
    }
}
