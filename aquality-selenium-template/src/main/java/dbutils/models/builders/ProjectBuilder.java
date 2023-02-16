package dbutils.models.builders;

import aquality.selenium.template.configuration.Configuration;
import dbutils.crud_models.ProjectCrud;
import dbutils.models.Project;

public class ProjectBuilder {
    public static Project build() {
        Project project = new Project(Configuration.getProjectName());
        project = ProjectCrud.read(project.getName());
        if (project == null) {
            ProjectCrud.create(new Project(Configuration.getProjectName()));
            project = ProjectCrud.read(Configuration.getProjectName());
        }
        return project;
    }
}
