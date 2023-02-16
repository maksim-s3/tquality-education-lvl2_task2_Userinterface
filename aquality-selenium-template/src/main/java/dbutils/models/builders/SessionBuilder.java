package dbutils.models.builders;

import aquality.selenium.template.configuration.Configuration;
import aquality.selenium.template.utilities.DateUtil;
import dbutils.crud_models.SessionCrud;
import dbutils.models.Session;
import java.util.Date;

public class SessionBuilder {
    private static final String TEMPLATE_TIME_SESSION = "yyyy-MM-dd HH:mm:ss";

    public static Session build() {
        Session session = new Session(DateUtil.getStringFromDate(TEMPLATE_TIME_SESSION, new Date()),
                DateUtil.getStringFromDate(TEMPLATE_TIME_SESSION, new Date()), Configuration.getBuildNumber());
        session.setId(SessionCrud.create(session));
        return session;
    }
}
