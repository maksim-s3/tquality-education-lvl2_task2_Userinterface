package tests.usecases;

import forms.CookiesForm;
import forms.pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TestCase3 extends BaseTest {
    @Test
    public void test() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not open");
        mainPage.clickStartLink();

        CookiesForm cookiesForm = new CookiesForm();
        cookiesForm.state().waitForDisplayed();
        cookiesForm.acceptCookies();
        Assert.assertTrue(cookiesForm.state().waitForNotDisplayed(), "Cookies form is not hidden");
    }
}
