package dbutils.crud_models;

import dbutils.DBConnector;
import dbutils.models.Status;

public class StatusCrud {
    private static final String INSERT_STATUS = "INSERT INTO status(name) VALUE ('%s');";
    private static final String SELECT_STATUS = "SELECT * FROM status WHERE name='%s';";
    private static final String UPDATE_STATUS = "UPDATE status SET name='%s' WHERE id=%d";
    private static final String DELETE_STATUS = "DELETE FROM status WHERE name='%s';";

    public static int create(Status status) {
        String sql = String.format(INSERT_STATUS, status.getName());
        return DBConnector.execute(sql);
    }

    public static Status read(String statusMessage) {
        String sql = String.format(SELECT_STATUS, statusMessage);
        return DBConnector.execute(sql, Status::new);
    }

    private static int update(Status status) {
        String sql = String.format(UPDATE_STATUS, status.getName(), status.getId());
        return DBConnector.execute(sql);
    }

    public static int delete(Status status) {
        String sql = String.format(DELETE_STATUS, status.getId());
        return DBConnector.execute(sql);
    }
}
