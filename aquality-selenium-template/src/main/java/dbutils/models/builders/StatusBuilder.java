package dbutils.models.builders;

import dbutils.crud_models.StatusCrud;
import dbutils.models.Status;

public class StatusBuilder {
    public static Status build(int statusCodeResult) {
        Status status = new Status(statusCodeResult);
        status = StatusCrud.read(status.getName());
        if (status == null) {
            StatusCrud.create(status);
            status = StatusCrud.read(status.getName());
        }
        return status;
    }
}
