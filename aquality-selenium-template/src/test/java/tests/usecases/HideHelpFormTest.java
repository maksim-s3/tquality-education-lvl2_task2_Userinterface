package tests.usecases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.steps.TestCaseSteps;

public class HideHelpFormTest extends BaseTest {
    private TestCaseSteps steps = new TestCaseSteps();

    @Description("Test case 2. Checking opened main page and help form is hidden")
    @Test
    public void test() {
        steps.goToMainPage();
        Assert.assertTrue(steps.getStateMainPage(), "Main page is not open");

        steps.clickLinkHERE();
        steps.hideHelpForm();
        Assert.assertTrue(steps.isHelpFormHidden(), "Help form is not hidden");
    }
}
