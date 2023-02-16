package tests.steps;

import aquality.selenium.template.configuration.Configuration;
import aquality.selenium.template.utilities.DateUtil;
import aquality.selenium.template.utilities.Random;
import dbutils.crud_models.TestCrud;
import dbutils.models.Author;
import dbutils.models.Project;
import dbutils.models.Test;
import dbutils.models.builders.AuthorBuilder;
import dbutils.models.builders.ProjectBuilder;
import forms.*;
import forms.pages.GamePage;
import forms.pages.MainPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import java.util.Date;
import java.util.List;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.template.utilities.AllureHelper.takeScreenshot;

public class TestCaseSteps {
    private static final String DEFAULT_URL = Configuration.getStartUrl();
    private static final String TEMPLATE_TIME_TEST = "yyyy-MM-dd HH:mm:ss";
    private static final int MIN_STATUS_CODE = 1;
    private static final int MAX_STATUS_CODE = 3;
    private SoftAssert softAssertion = new SoftAssert();
    private MainPage mainPage = new MainPage();
    private LoginForm loginForm = new LoginForm();
    private AvatarAndInterestsForm avatarAndInterestsForm = new AvatarAndInterestsForm();
    private PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
    private CookiesForm cookiesForm = new CookiesForm();
    private HelpForm helpForm = new HelpForm();
    private GamePage gamePage = new GamePage();

    @Step("Go to main page")
    public void goToMainPage() {
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
    public void fillingAvatarAndInterestsForm(int numberInterests) {
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
    private void waitForDisplayedCookies() {
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
    public void hideHelpForm() {
        helpForm.state().waitForDisplayed();
        takeScreenshot();
        helpForm.clickHideButton();
    }

    @Step("Check is help form hidden")
    public boolean isHelpFormHidden() {
        boolean state = helpForm.isFormHiden();
        takeScreenshot();
        return state;
    }

    @Step("Get timer from site")
    public Date getTimerFromSite(String templateTimerTime) {
        Date timer = DateUtil.getDateFromString(templateTimerTime, gamePage.getTimer());
        takeScreenshot();
        return timer;
    }

    @Step("Simulate running copied test")
    public void runTests(List<Test> listTests) {
        for (Test test : listTests) {
            test.setStatus_id(Random.getRandomIntNumber(MIN_STATUS_CODE, MAX_STATUS_CODE));
            test.setStart_time(DateUtil.getStringFromDate(TEMPLATE_TIME_TEST, new Date()));
            test.setEnd_time(DateUtil.getStringFromDate(TEMPLATE_TIME_TEST, new Date()));
            TestCrud.update(test);
        }
    }

    @Step("Check information copied test")
    public void assertUpdatedTestInformation(List<Test> copiedTests, List<Test> selectedTests) {
        for (int i = 0; i < copiedTests.size(); i++) {
            softAssertion.assertNotEquals(copiedTests.get(i).getAuthor_id(), selectedTests.get(i).getAuthor_id());
            softAssertion.assertNotEquals(copiedTests.get(i).getProject_id(), selectedTests.get(i).getProject_id());
            softAssertion.assertNotEquals(copiedTests.get(i).getStart_time(), selectedTests.get(i).getStart_time());
            softAssertion.assertNotEquals(copiedTests.get(i).getEnd_time(), selectedTests.get(i).getEnd_time());
        }
    }

    @Step("Delete copied test")
    public void deleteTests(List<Test> listTests) {
        for (Test test : listTests) {
            TestCrud.delete(test);
        }
    }

    @Step("Select tests from a database where the ID contains two random repeating digits and copy them")
    public int selectAndCopySpecificIdTests(int randomDigit, int maxNumberTestsToRun, String authorName, String authorLogin, String authorEmail) {
        Project project = ProjectBuilder.build();
        Author author = AuthorBuilder.build(authorName, authorLogin, authorEmail);
        return TestCrud.selectAndCopySpecificIdTests(randomDigit, maxNumberTestsToRun, project.getId(), author.getId());
    }

    @Step("Get tests from a database where the ID contains two random repeating digits")
    public List<Test> getSelectedTests(int randomDigit, int maxNumberTestsToRun) {
        return TestCrud.getTestsWhereIdContainsTwoRepeatDigits(randomDigit, maxNumberTestsToRun);
    }

    @Step("Get new copied tests")
    public List<Test> getCopiedTests(int numberTestsToRun) {
        return TestCrud.getLastTests(numberTestsToRun);
    }
}
