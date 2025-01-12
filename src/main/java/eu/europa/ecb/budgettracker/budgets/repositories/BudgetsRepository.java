package eu.europa.ecb.budgettracker.budgets.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BudgetsRepository extends MongoRepository<BudgetDocument, Integer> {

}
