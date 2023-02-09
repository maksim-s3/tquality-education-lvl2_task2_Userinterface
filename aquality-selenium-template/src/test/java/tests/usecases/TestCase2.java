package tests.usecases;

import forms.HelpForm;
import forms.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TestCase2 extends BaseTest {
    @Test
    public void test() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not open");
        mainPage.clickStartLink();

        HelpForm helpForm = new HelpForm();
        helpForm.state().waitForDisplayed();
        helpForm.clickHideButton();
        Assert.assertTrue(helpForm.isFormHiden(), "Help form is not hidden");
    }
}
