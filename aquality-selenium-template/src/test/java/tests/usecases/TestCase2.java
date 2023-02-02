package tests.usecases;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.template.forms.forms.HelpForm;
import aquality.selenium.template.forms.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TestCase2 extends BaseTest {
    @Test
    public void test() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed());
        mainPage.clickStartLink();

        HelpForm helpForm = new HelpForm();
        helpForm.clickHideButton();
        Assert.assertTrue(helpForm.isFormHiden());
    }
}
