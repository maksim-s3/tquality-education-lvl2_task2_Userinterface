package dbutils.crud_models;

import dbutils.DBConnector;
import dbutils.models.Session;

public class SessionCrud {
    private static final String INSERT_SESSION = "INSERT INTO session(session_key, build_number) VALUE ('%s', '%s');";
    private static final String SELECT_SESSION = "SELECT * FROM session WHERE id='%s';";
    private static final String UPDATE_SESSION = "UPDATE session SET session_key='%s', created_time='%s' build_number='%s' WHERE id='%s';";
    private static final String DELETE_SESSION = "DELETE FROM session WHERE id='%s';";

    public static int create(Session session) {
        String sql = String.format(INSERT_SESSION, session.getSession_key(), session.getBuild_number());
        return DBConnector.execute(sql);
    }

    public static Session read(int id) {
        String sql = String.format(SELECT_SESSION, id);
        return DBConnector.execute(sql, Session::new);
    }

    private static int update(Session session) {
        String sql = String.format(UPDATE_SESSION, session.getSession_key(), session.getCreated_time(), session.getBuild_number(), session.getId());
        return DBConnector.execute(sql);
    }

    public static int delete(Session session) {
        String sql = String.format(DELETE_SESSION, session.getId());
        return DBConnector.execute(sql);
    }
}
