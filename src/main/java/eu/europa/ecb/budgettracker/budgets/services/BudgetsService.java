package eu.europa.ecb.budgettracker.budgets.services;

import eu.europa.ecb.budgettracker.budgets.dtos.Budget;
import eu.europa.ecb.budgettracker.budgets.repositories.BudgetDocument;
import eu.europa.ecb.budgettracker.budgets.repositories.BudgetsRepository;
import eu.europa.ecb.budgettracker.budgets.repositories.exceptions.DocumentNotFoundException;
import eu.europa.ecb.budgettracker.projects.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BudgetsService {

    private final BudgetsRepository budgetsRepository;
    private final ProjectsService projectsService;

    public Budget findByProjectId(int projectId) {
        if (!projectsService.exists(projectId)) {
            throw new DocumentNotFoundException("Project with id %s does not exist".formatted(projectId));
        }

        return budgetsRepository.findByProjectId(projectId)
                .map(BudgetDocument::toDto)
                .orElseThrow(() -> new DocumentNotFoundException(
                        "There is no budget associated to project with id %s".formatted(projectId)));
    }

    public Budget save(Budget budget, int projectId) {
        if (!projectsService.exists(projectId)) {
            throw new DocumentNotFoundException("Project with id %s does not exist".formatted(projectId));
        }

        final var budgetEntity = BudgetDocument.fromDto(budget, projectId);
        return BudgetDocument.toDto(budgetsRepository.save(budgetEntity));
    }
}
