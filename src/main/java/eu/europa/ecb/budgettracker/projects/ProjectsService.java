package eu.europa.ecb.budgettracker.projects;

import eu.europa.ecb.budgettracker.projects.dtos.Project;
import eu.europa.ecb.budgettracker.projects.repositories.ProjectDocument;
import eu.europa.ecb.budgettracker.projects.repositories.ProjectsRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectsService {
  private final ProjectsRepository projectsRepository;

  public List<Project> findAll() {
    return projectsRepository.findAll().stream().map(ProjectDocument::toDto).toList();
  }

  public boolean exists(int projectId) {
    return projectsRepository.existsById(projectId);
  }
}
