package dbutils.crud_models;

import dbutils.DBConnector;
import dbutils.models.Test;
import java.util.List;

public class TestCrud {
    private static final String INSERT_TEST = "INSERT INTO test(name, status_id, method_name, project_id, session_id, " +
            "start_time, end_time, env, browser, author_id)  VALUE ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
    private static final String UPDATE_TEST = "UPDATE test SET name='%s', status_id=%d, method_name='%s', project_id=%d, session_id=%d, start_time='%s', end_time='%s', env='%s', browser='%s', author_id=%d WHERE id=%d;";
    private static final String SELECT_TEST = "SELECT * FROM test WHERE id=%d;";
    private static final String DELETE_TEST = "DELETE FROM test WHERE id='%d';";
    private static final String SELECT_SPECIFIC_ID_TESTS = "SELECT * FROM test WHERE id REGEXP '%d{2}' LIMIT %d;";
    private static final String SELECT_LAST_TESTS = "SELECT * FROM(SELECT * FROM test ORDER BY id DESC LIMIT %d) AS sub ORDER BY id ASC;";
    private static final String INSERT_SPECIFIC_ID_TESTS = "INSERT INTO test (name, status_id, method_name, project_id, session_id, start_time, end_time, env, browser, author_id)\n" +
            "\tSELECT name, status_id, method_name, %d, session_id, start_time, end_time, env, browser, %d FROM test WHERE id REGEXP '%d{2}' LIMIT %d;";

    public static int create(Test test) {
        String sql = String.format(INSERT_TEST, test.getName(), test.getStatus_id(), test.getMethod_name(),
                test.getProject_id(), test.getSession_id(), test.getStart_time(), test.getEnd_time(), test.getEnv(), test.getBrowser(), test.getAuthor_id());
        return DBConnector.execute(sql);
    }

    public static Test read(int id) {
        String sql = String.format(SELECT_TEST, id);
        return DBConnector.execute(sql, Test::new);
    }

    public static int update(Test test) {
        String sql = String.format(UPDATE_TEST, test.getName(), test.getStatus_id(), test.getMethod_name(),
                test.getProject_id(), test.getSession_id(), test.getStart_time(), test.getEnd_time(), test.getEnv(), test.getBrowser(), test.getAuthor_id(), test.getId());
        return DBConnector.execute(sql);
    }

    public static int delete(Test test) {
        String sql = String.format(DELETE_TEST, test.getId());
        return DBConnector.execute(sql);
    }

    public static List<Test> getTestsWhereIdContainsTwoRepeatDigits(int number, int limit){
        String sql = String.format(SELECT_SPECIFIC_ID_TESTS, number, limit);
        return DBConnector.executeListModel(sql, Test::new);
    }

    public static List<Test> getLastTests(int numberLastTests) {
        String sql = String.format(SELECT_LAST_TESTS, numberLastTests);
        return DBConnector.executeListModel(sql, Test::new);
    }

    public static int selectAndCopySpecificIdTests(int number, int maxNumberResults, int projectId, int authorId) {
        String sql = String.format(INSERT_SPECIFIC_ID_TESTS, projectId, authorId, number, maxNumberResults);
        return DBConnector.executeGetUpdateCount(sql);
    }
}


