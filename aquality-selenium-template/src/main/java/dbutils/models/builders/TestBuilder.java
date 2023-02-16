package dbutils.models.builders;

import aquality.selenium.template.configuration.Configuration;
import aquality.selenium.template.utilities.DateUtil;
import dbutils.models.*;
import org.testng.ISuite;
import org.testng.ITestResult;
import java.util.Date;

public class TestBuilder {
    private static final String TEMPLATE_TIME_TEST = "yyyy-MM-dd HH:mm:ss";
    private static final String NAME_PARAMETER_SUIT_AUTHOR_NAME = "authorName";
    private static final String NAME_PARAMETER_SUIT_AUTHOR_LOGIN = "authorLogin";
    private static final String NAME_PARAMETER_SUIT_AUTHOR_EMAIL = "authorEmail";

    public static Test build(ITestResult testResult) {
        ISuite suite = testResult.getTestContext().getSuite();
        Status status = StatusBuilder.build(testResult.getStatus());
        Project project = ProjectBuilder.build();
        Session session = SessionBuilder.build();
        Author author = AuthorBuilder.build(suite.getParameter(NAME_PARAMETER_SUIT_AUTHOR_NAME),
                suite.getParameter(NAME_PARAMETER_SUIT_AUTHOR_LOGIN), suite.getParameter(NAME_PARAMETER_SUIT_AUTHOR_EMAIL));

        Test test = new Test();
        test.setName(testResult.getTestContext().getName());
        test.setStatus_id(status.getId());
        test.setMethod_name(testResult.getMethod().getQualifiedName());
        test.setProject_id(project.getId());
        test.setSession_id(session.getId());
        test.setStart_time(DateUtil.getStringFromDate(TEMPLATE_TIME_TEST, new Date(testResult.getEndMillis())));
        test.setEnd_time(DateUtil.getStringFromDate(TEMPLATE_TIME_TEST, new Date(testResult.getStartMillis())));
        test.setEnv(Configuration.getEnvironmentName());
        test.setBrowser(Configuration.getBrowserName());
        test.setAuthor_id(author.getId());
        return test;
    }
}
