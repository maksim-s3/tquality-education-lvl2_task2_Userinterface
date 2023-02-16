package dbutils;

import aquality.selenium.template.configuration.Configuration;
import dbutils.models.TableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class DBConnector {
    private final static String DB_URL = Configuration.getDBUrl();
    private final static String DB_USERNAME = Configuration.getDBUserName();
    private final static String DB_PASSWORD = Configuration.getDBPassword();

    private static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static <T extends TableModel> T execute(String sql, Supplier<T> model) {
        T newModel = null;
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                newModel = model.get();
                newModel.fill(rs);
            }
            return newModel;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int execute(String sql) {
        try (Connection connection = DBConnector.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            int autoIncKeyFromApi = -1;
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                autoIncKeyFromApi = rs.getInt(1);
            }
            return autoIncKeyFromApi;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int executeGetUpdateCount(String sql) {
        try (Connection connection = DBConnector.getConnection();
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            return stmt.getUpdateCount();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T extends TableModel> List<T> executeListModel(String sql, Supplier<T> model) {
        List<T> models = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                T newModel = model.get();
                newModel.fill(rs);
                models.add(newModel);
            }
            return models;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
