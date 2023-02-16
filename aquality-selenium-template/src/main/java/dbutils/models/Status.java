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
public class Status extends TableModel {
    private Integer id;
    private String name;

    public Status(int statusTestResult) {
        switch (statusTestResult) {
            case 1:
                this.name = ResultStatuses.PASSED.getTitle();
                break;
            case 2:
                this.name = ResultStatuses.FAILED.getTitle();
                break;
            case 3:
                this.name = ResultStatuses.SKIPPED.getTitle();
                break;
            default:
                throw new RuntimeException("Invalid status code of the test result");
        }
    }

    public void fill(ResultSet rs) throws SQLException {
        this.setId(rs.getInt("id"));
        this.setName(rs.getString("name"));
    }
}
