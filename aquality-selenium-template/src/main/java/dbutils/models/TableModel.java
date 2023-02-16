package dbutils.models;

import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class TableModel {
    public void fill(ResultSet resultSet) throws SQLException {
    }
}
