package dbutils.models;

import lombok.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session extends TableModel {
    private Integer id;
    private String session_key;
    private String created_time;
    private Integer build_number;

    public Session(String session_key, String created_time, Integer build_number) {
        this.session_key = session_key;
        this.created_time = created_time;
        this.build_number = build_number;
    }

    public void fill(ResultSet rs) throws SQLException {
        this.setId(rs.getInt("id"));
        this.setSession_key(rs.getString("session_key"));
        this.setCreated_time(rs.getString("created_time"));
        this.setBuild_number(rs.getInt("build_number"));
    }
}
