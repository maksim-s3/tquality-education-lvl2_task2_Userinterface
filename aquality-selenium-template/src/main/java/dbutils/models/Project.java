package dbutils.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project extends TableModel {
    private Integer id;
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public void fill(ResultSet rs) throws SQLException {
        this.setId(rs.getInt("id"));
        this.setName(rs.getString("name"));
    }
}
