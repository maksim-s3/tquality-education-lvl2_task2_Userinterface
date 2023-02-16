package dbutils.crud_models;

import dbutils.DBConnector;
import dbutils.models.Author;

public class AuthorCrud {
    private static final String INSERT_AUTHOR = "INSERT INTO author(name, login, email) VALUE ('%s', '%s', '%s');";
    private static final String SELECT_AUTHOR = "SELECT * FROM author WHERE login='%s';";
    private static final String UPDATE_AUTHOR = "UPDATE author SET name='%s', email='%s' WHERE login='%s';";
    private static final String DELETE_AUTHOR = "DELETE FROM author WHERE login='%s';";

    public static int create(Author author) {
        String sql = String.format(INSERT_AUTHOR, author.getName(), author.getLogin(), author.getEmail());
        return DBConnector.execute(sql);
    }

    public static Author read(String authorLogin) {
        String sql = String.format(SELECT_AUTHOR, authorLogin);
        return DBConnector.execute(sql, Author::new);
    }

    private static int update(Author author) {
        String sql = String.format(UPDATE_AUTHOR, author.getName(), author.getEmail(), author.getLogin());
        return DBConnector.execute(sql);
    }

    public static int delete(Author author) {
        String sql = String.format(DELETE_AUTHOR, author.getLogin());
        return DBConnector.execute(sql);
    }
}
