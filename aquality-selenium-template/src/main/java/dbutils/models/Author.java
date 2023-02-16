package dbutils.models;

import lombok.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Author extends TableModel {
    private Integer id;
    private String name;
    private String login;
    private String email;

    public Author(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }

    public void fill(ResultSet rs) throws SQLException {
        this.setId(rs.getInt("id"));
        this.setName(rs.getString("name"));
        this.setLogin(rs.getString("login"));
        this.setEmail(rs.getString("email"));
    }
}

