package eu.europa.ecb.budgettracker.projects.apis;

import eu.europa.ecb.budgettracker.projects.dtos.Project;
import eu.europa.ecb.budgettracker.projects.ProjectsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/projects")
public class ProjectsController {

  private final ProjectsService projectsService;

  @GetMapping
  public ResponseEntity<List<Project>> findAll() {
    return ResponseEntity.ok(projectsService.findAll());
  }
}
