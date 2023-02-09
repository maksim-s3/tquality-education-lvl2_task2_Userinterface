package tests.usecases;

import forms.AvatarAndInterestsForm;
import forms.LoginForm;
import forms.PersonalDetailsForm;
import forms.pages.MainPage;
import aquality.selenium.template.utilities.Random;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TestCase1 extends BaseTest {

    @Test
    public void test() {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed(), "Main page is not open");
        mainPage.clickStartLink();

        LoginForm loginForm = new LoginForm();
        Assert.assertTrue(loginForm.state().waitForDisplayed(), "Login form is not open");
        Assert.assertEquals(loginForm.getPageIndicator(), 1);
        loginForm.setPassword(Random.getRandomPassword() + "ь");
        loginForm.setEmail(Random.getRandomName());
        loginForm.setDomain(Random.getRandomDomainWord());
        loginForm.selectRandomDomainSuffix();
        loginForm.uncheckCheckBoxAcceptTerms();
        loginForm.clickButtonNext();

        AvatarAndInterestsForm avatarAndInterestsForm = new AvatarAndInterestsForm();
        Assert.assertTrue(avatarAndInterestsForm.state().waitForDisplayed(), "Avatar and interests form is not open");
        Assert.assertEquals(avatarAndInterestsForm.getPageIndicator(), 2);
        avatarAndInterestsForm.uncheckCheckBoxAllInterests();
        avatarAndInterestsForm.checkNumberRandomInterest(3);
        avatarAndInterestsForm.uploadImage();
        avatarAndInterestsForm.clickNextButton();

        PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed(), "Personal Details form is not open");
        Assert.assertEquals(personalDetailsForm.getPageIndicator(), 3);
    }
}
