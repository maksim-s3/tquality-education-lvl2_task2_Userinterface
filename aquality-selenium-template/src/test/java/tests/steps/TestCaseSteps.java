package tests.steps;

import aquality.selenium.template.configuration.Configuration;
import aquality.selenium.template.utilities.DateUtil;
import aquality.selenium.template.utilities.Random;
import forms.*;
import forms.pages.GamePage;
import forms.pages.MainPage;
import io.qameta.allure.Step;
import java.util.Date;
import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.template.utilities.AllureHelper.takeScreenshot;

public class TestCaseSteps {
    private static final String DEFAULT_URL = Configuration.getStartUrl();
    private MainPage mainPage = new MainPage();
    private LoginForm loginForm = new LoginForm();
    private AvatarAndInterestsForm avatarAndInterestsForm = new AvatarAndInterestsForm();
    private PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
    private CookiesForm cookiesForm = new CookiesForm();
    private HelpForm helpForm = new HelpForm();
    private GamePage gamePage = new GamePage();

    @Step("Go to main page")
    public void goToMainPage(){
        getBrowser().goTo(DEFAULT_URL);
        getBrowser().maximize();
        takeScreenshot();
    }

    @Step("Get state main page")
    public boolean getStateMainPage() {
        boolean state = mainPage.state().waitForDisplayed();
        takeScreenshot();
        return state;
    }

    @Step("Click link (in text 'Please click HERE to GO to the next page')")
    public void clickLinkHERE() {
        mainPage.clickStartLink();
        takeScreenshot();
    }

    @Step("Get login form card number")
    public int getPageIndicatorLoginForm() {
        takeScreenshot();
        return loginForm.getPageIndicator();
    }

    @Step("Filling login form with random values and and go to the next page")
    public void fillingLoginForm() {
        loginForm.setPassword(Random.getRandomPassword() + "ь");
        loginForm.setEmail(Random.getRandomName());
        loginForm.setDomain(Random.getRandomDomainWord());
        loginForm.selectRandomDomainSuffix();
        loginForm.uncheckCheckBoxAcceptTerms();
        takeScreenshot();
        loginForm.clickButtonNext();
    }

    @Step("Get avatar and interests form card number")
    public int getPageIndicatorAvatarAndInterestsForm() {
        takeScreenshot();
        return avatarAndInterestsForm.getPageIndicator();
    }

    @Step("Filling avatar and interests form with random interests, upload image and go to the next page")
    public void fillingAvatarAndInterestsForm(int numberInterests){
        avatarAndInterestsForm.uncheckCheckBoxAllInterests();
        avatarAndInterestsForm.checkNumberRandomInterest(numberInterests);
        avatarAndInterestsForm.uploadImage();
        takeScreenshot();
        avatarAndInterestsForm.clickNextButton();
    }

    @Step("Get personal details form card number")
    public int getPageIndicatorPersonalDetailsForm() {
        int cardNumber = personalDetailsForm.getPageIndicator();
        takeScreenshot();
        return cardNumber;
    }

    @Step("Click accept cookies")
    public void accessCookies() {
        waitForDisplayedCookies();
        cookiesForm.acceptCookies();
        takeScreenshot();
    }

    @Step("Wait for displayed cookies form")
    private void waitForDisplayedCookies(){
        cookiesForm.state().waitForDisplayed();
        takeScreenshot();
    }

    @Step("Get state cookies form")
    public boolean getStateFormCookies() {
        boolean state = cookiesForm.state().waitForNotDisplayed();
        takeScreenshot();
        return state;
    }

    @Step("Click hide help form")
    public void hideHelpForm(){
        helpForm.state().waitForDisplayed();
        takeScreenshot();
        helpForm.clickHideButton();
    }

    @Step("Check is help form hidden")
    public boolean isHelpFormHidden(){
        boolean state = helpForm.isFormHiden();
        takeScreenshot();
        return state;
    }

    @Step("Get timer from site")
    public Date getTimerFromSite(String templateTimerTime){
        Date timer = DateUtil.getDateFromString(templateTimerTime, gamePage.getTimer());
        takeScreenshot();
        return timer;
    }
}
