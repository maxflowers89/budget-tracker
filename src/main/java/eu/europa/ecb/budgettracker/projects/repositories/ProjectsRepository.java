package eu.europa.ecb.budgettracker.projects.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectsRepository extends MongoRepository<ProjectDocument, Integer> {
}
