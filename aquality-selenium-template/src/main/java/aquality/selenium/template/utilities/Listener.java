package aquality.selenium.template.utilities;

import dbutils.crud_models.TestCrud;
import dbutils.models.Test;
import dbutils.models.builders.TestBuilder;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        AllureHelper.takeScreenshot();
        AllureHelper.takeLog();
        Test test = TestBuilder.build(result);
        TestCrud.create(test);
    }

    public void onTestSuccess(ITestResult result) {
        AllureHelper.takeLog();
        Test test = TestBuilder.build(result);
        TestCrud.create(test);
    }
}
