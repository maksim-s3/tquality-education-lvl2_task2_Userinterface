package tests.usecases;

import forms.pages.GamePage;
import forms.pages.MainPage;
import aquality.selenium.template.utilities.DateUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;
import java.util.Date;

public class TestCase4 extends BaseTest {
    private static final String TEMPLATE_TIMER_TIME = "HH:mm:ss";

    @Test
    public void test() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not open");
        mainPage.clickStartLink();

        GamePage gamePage = new GamePage();
        Date timer = DateUtil.getDateFromString(TEMPLATE_TIMER_TIME, gamePage.getTimer());
        Assert.assertEquals(DateUtil.getStringFromDate(TEMPLATE_TIMER_TIME, timer), "00:00:00", "Initial value of the timer does not match");
    }
}
