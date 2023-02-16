package tests.usecases;

import aquality.selenium.template.utilities.Random;
import dbutils.models.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import tests.steps.TestCaseSteps;
import java.util.List;

public class TestDataProcessing {
    private TestCaseSteps steps = new TestCaseSteps();
    private int numberTestsToRun;
    private List<Test> copiedTests;
    private List<Test> selectedTests;

    @Parameters({"maxNumberTestsToRun", "authorName", "authorLogin", "authorEmail"})
    @BeforeMethod
    public void setUp(int maxNumberTestsToRun, String authorName, String authorLogin, String authorEmail) {
        int randomDigit = Random.getRandomIntNumber(1, 9);
        numberTestsToRun = steps.selectAndCopySpecificIdTests(randomDigit, maxNumberTestsToRun, authorName, authorLogin, authorEmail);
        selectedTests = steps.getSelectedTests(randomDigit, maxNumberTestsToRun);
        copiedTests = steps.getCopiedTests(numberTestsToRun);
    }

    @org.testng.annotations.Test
    public void test() {
        steps.runTests(copiedTests);
        copiedTests = steps.getCopiedTests(numberTestsToRun);
        steps.assertUpdatedTestInformation(copiedTests, selectedTests);
    }

    @AfterMethod
    public void tearDown() {
        steps.deleteTests(copiedTests);
    }
}
