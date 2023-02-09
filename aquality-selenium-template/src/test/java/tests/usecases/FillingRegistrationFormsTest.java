package tests.usecases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import tests.steps.TestCaseSteps;

public class FillingRegistrationFormsTest extends BaseTest {
    private static int NUMBER_FIRST_CARD = 1;
    private static int NUMBER_TWO_CARD = 2;
    private static int NUMBER_THREE_CARD = 3;
    private TestCaseSteps steps = new TestCaseSteps();

    @Description("Test case 1. Checking opened main page and filling of forms and cards number")
    @Parameters("numberInterests")
    @Test
    public void test(int numberInterests) {
        steps.goToMainPage();
        Assert.assertTrue(steps.getStateMainPage(), "Main page is not open");

        steps.clickLinkHERE();
        Assert.assertEquals(steps.getPageIndicatorLoginForm(), NUMBER_FIRST_CARD, "Number card is not match");

        steps.fillingLoginForm();
        Assert.assertEquals(steps.getPageIndicatorAvatarAndInterestsForm(), NUMBER_TWO_CARD, "Number card is not match");

        steps.fillingAvatarAndInterestsForm(numberInterests);
        Assert.assertEquals(steps.getPageIndicatorPersonalDetailsForm(), NUMBER_THREE_CARD, "Number card is not match");
    }
}
