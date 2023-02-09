package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import custom_elements.CustomCheckBox;
import custom_elements.CustomDropDown;
import org.openqa.selenium.By;

public class LoginForm extends Form {
    private ILabel pageIndicator = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'page-indicator')]"), "Page indicator");
    private ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder, 'Choose Password')]"), "password");
    private ITextBox txbEmail = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder, 'Your email')]"), "email");
    private ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder, 'Domain')]"), "domain");
    private IButton buttonDropDown = getElementFactory().getButton(By.xpath("//*[contains(@class, 'dropdown__opener')]"), "dropdown");
    private CustomDropDown ddDomainSuffix = getElementFactory().getCustomElement(CustomDropDown::new, By.xpath("//*[@class='dropdown__list']"), "dropdown");
    private IButton buttonNext = getElementFactory().getButton(By.xpath("//*[contains(@class, 'button--secondary') and text()='Next']"), "Next in form login");
    private ICheckBox checkboxAcceptTerms = getElementFactory().getCustomElement(CustomCheckBox::new, By.xpath("//*[contains(@class, 'icon icon-check checkbox__check')]"), "accept terms conditions");

    public LoginForm() {
        super(By.xpath("//*[contains(@class, 'login-form')]"), "Login form");
    }

    public int getPageIndicator(){
        return Integer.parseInt(pageIndicator.getText().substring(0, 1));
    }

    public void setPassword(String value) {
        txbPassword.clearAndType(value);
    }

    public void setEmail(String value) {
        txbEmail.clearAndType(value);
    }

    public void setDomain(String value) {
        txbDomain.clearAndType(value);
    }

    public void selectRandomDomainSuffix() {
        buttonDropDown.click();
        ddDomainSuffix.selectByRandomIndex();

    }

    public void uncheckCheckBoxAcceptTerms() {
        checkboxAcceptTerms.toggle();
    }

    public void clickButtonNext() {
        buttonNext.click();
    }
}
