package tests.usecases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.steps.TestCaseSteps;

public class AccessCookiesTest extends BaseTest {
    private TestCaseSteps steps = new TestCaseSteps();

    @Description("Test case 3. Checking opened main page and accept cookies")
    @Test
    public void test() {
        steps.goToMainPage();
        Assert.assertTrue(steps.getStateMainPage(), "Main page is not open");

        steps.clickLinkHERE();
        steps.accessCookies();
        steps.getStateFormCookies();
        Assert.assertTrue(steps.getStateFormCookies(), "Cookies form is not hidden");
    }
}
