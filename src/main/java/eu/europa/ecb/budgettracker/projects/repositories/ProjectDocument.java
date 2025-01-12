package eu.europa.ecb.budgettracker.projects.repositories;

import eu.europa.ecb.budgettracker.projects.dtos.Project;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "projects")
public class ProjectDocument {
    @Id
    private int id;
    private String name;

    public static Project toDto(ProjectDocument projectDocument) {
        return new Project(projectDocument.id, projectDocument.name);
    }
}
