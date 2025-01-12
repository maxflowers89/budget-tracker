package eu.europa.ecb.budgettracker.budgets.apis;

import eu.europa.ecb.budgettracker.budgets.dtos.Budget;
import eu.europa.ecb.budgettracker.budgets.services.BudgetsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/budget")
public class BudgetsController {

    private final BudgetsService budgetsService;

    @GetMapping
    public ResponseEntity<Budget> getBudget(@RequestParam int projectId) {
        return ResponseEntity.ok(budgetsService.findByProjectId(projectId));
    }

    @PostMapping
    public ResponseEntity<Budget> save(@Valid @RequestBody Budget budget,
                                       @RequestParam int projectId) {
        return ResponseEntity.ok(budgetsService.save(budget, projectId));
    }
}
