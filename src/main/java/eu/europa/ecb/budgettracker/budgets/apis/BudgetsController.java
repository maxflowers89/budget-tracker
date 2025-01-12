package eu.europa.ecb.budgettracker.budgets.apis;

import eu.europa.ecb.budgettracker.budgets.dtos.Budget;
import eu.europa.ecb.budgettracker.budgets.services.BudgetsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/budget")
public class BudgetsController {

  private final BudgetsService budgetsService;

  @PostMapping
  public ResponseEntity<Budget> save(@Valid @RequestBody Budget budget,
      @RequestParam int projectId) {
    return ResponseEntity.ok(budgetsService.save(budget, projectId));
  }
}
