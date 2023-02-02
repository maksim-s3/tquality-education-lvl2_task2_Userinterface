package tests.usecases;

import aquality.selenium.template.forms.forms.AvatarAndInterestsForm;
import aquality.selenium.template.forms.forms.LoginForm;
import aquality.selenium.template.forms.forms.PersonalDetailsForm;
import aquality.selenium.template.forms.pages.MainPage;
import aquality.selenium.template.utilities.Random;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

public class TestCase1 extends BaseTest{

    @Test
    public void test(){
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.state().waitForDisplayed());
        mainPage.clickStartLink();

        LoginForm loginForm = new LoginForm();
        loginForm.setPassword(Random.getRandomPassword()+"ь");
        loginForm.setEmail(Random.getRandomName());
        loginForm.setDomain(Random.getRandomDomainWord());
        loginForm.setDomainSuffix();
        loginForm.uncheckCheckBoxAcceptTerms();
        loginForm.clickButtonNext();

        AvatarAndInterestsForm avatarAndInterestsForm = new AvatarAndInterestsForm();
        Assert.assertTrue(avatarAndInterestsForm.state().waitForDisplayed());
        avatarAndInterestsForm.unselectAllInterests();
        avatarAndInterestsForm.checkNumberRandomInterest(3);
        avatarAndInterestsForm.clickDownload();

        PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed());


        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
