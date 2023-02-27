package tests.usecases;

import aquality.selenium.template.utilities.DateUtil;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.steps.TestCaseSteps;

public class TimerAtZeroTest extends BaseTest {
    private static final String TEMPLATE_TIMER_TIME = "HH:mm:ss";
    private static final String EXPECTED_TIME_ZERO = "00:00:00";
    private TestCaseSteps steps = new TestCaseSteps();

    @Description("Test case 4. Checking timer starts with at zero")
    @Test
    public void test() {
        steps.goToMainPage();
        steps.clickLinkHERE();
        Assert.assertEquals(DateUtil.getStringFromDate(TEMPLATE_TIMER_TIME, steps.getTimerFromSite(TEMPLATE_TIMER_TIME)),
                EXPECTED_TIME_ZERO, "Initial value of the timer does not match");
    }
}
