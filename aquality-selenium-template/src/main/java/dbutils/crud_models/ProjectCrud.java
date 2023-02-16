package dbutils.crud_models;

import dbutils.DBConnector;
import dbutils.models.Project;

public class ProjectCrud {
    private static final String INSERT_PROJECT = "INSERT INTO project(name) VALUE ('%s');";
    private static final String SELECT_PROJECT = "SELECT * FROM project WHERE name='%s';";
    private static final String UPDATE_PROJECT = "UPDATE project SET name='%s' WHERE id=%d;";
    private static final String DELETE_PROJECT = "DELETE FROM project WHERE name='%s';";

    public static int create(Project project) {
        String sql = String.format(INSERT_PROJECT, project.getName());
        return DBConnector.execute(sql);
    }

    public static Project read(String projectName) {
        String sql = String.format(SELECT_PROJECT, projectName);
        return DBConnector.execute(sql, Project::new);
    }

    private static int update(Project project) {
        String sql = String.format(UPDATE_PROJECT, project.getName(), project.getId());
        return DBConnector.execute(sql);
    }

    public static int delete(Project project) {
        String sql = String.format(DELETE_PROJECT, project.getName());
        return DBConnector.execute(sql);
    }
}
