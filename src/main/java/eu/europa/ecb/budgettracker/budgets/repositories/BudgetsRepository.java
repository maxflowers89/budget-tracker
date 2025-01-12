package eu.europa.ecb.budgettracker.budgets.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BudgetsRepository extends MongoRepository<BudgetDocument, Integer> {

    Optional<BudgetDocument> findByProjectId(int projectId);
}