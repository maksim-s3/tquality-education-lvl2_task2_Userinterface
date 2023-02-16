package dbutils.models.builders;

import dbutils.crud_models.AuthorCrud;
import dbutils.models.Author;

public class AuthorBuilder {

    public static Author build(String name, String login, String email) {
        Author author = AuthorCrud.read(login);
        if (author == null) {
            author = new Author(name, login, email);
            AuthorCrud.create(author);
            author = AuthorCrud.read(login);
        }
        return author;
    }
}
