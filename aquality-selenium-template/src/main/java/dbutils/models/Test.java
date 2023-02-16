package dbutils.models;

import lombok.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Test extends TableModel {
    private Integer id;
    private String name;
    private Integer status_id;
    private String method_name;
    private Integer project_id;
    private Integer session_id;
    private String start_time;
    private String end_time;
    private String env;
    private String browser;
    private Integer author_id;

    public Test(String name, Integer status_id, String method_name, Integer project_id, Integer session_id, String start_time, String end_time, String env, String browser, Integer author_id) {
        this.name = name;
        this.status_id = status_id;
        this.method_name = method_name;
        this.project_id = project_id;
        this.session_id = session_id;
        this.start_time = start_time;
        this.end_time = end_time;
        this.env = env;
        this.browser = browser;
        this.author_id = author_id;
    }

    public void fill(ResultSet rs) throws SQLException {
        setId(rs.getInt("id"));
        setName(rs.getString("name"));
        setStatus_id(rs.getInt("status_id"));
        setMethod_name(rs.getString("method_name"));
        setProject_id(rs.getInt("project_id"));
        setSession_id(rs.getInt("session_id"));
        setStart_time(rs.getString("start_time"));
        setEnd_time(rs.getString("end_time"));
        setEnv(rs.getString("env"));
        setBrowser(rs.getString("browser"));
        setAuthor_id(rs.getInt("author_id"));
    }
}
