package aquality.selenium.template.forms.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import aquality.selenium.template.custom_elements.CustomCheckBox;
import aquality.selenium.template.custom_elements.CustomDropDown;
import org.openqa.selenium.By;

public class LoginForm extends Form {
    private ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder, 'Choose Password')]") , "Input Password");
    private ITextBox txbEmail = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder, 'Your email')]") , "Input email");
    private ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//*[contains(@placeholder, 'Domain')]") , "Input Domain");
    private IButton buttonDropDown = getElementFactory().getButton(By.xpath("//*[contains(@class, 'dropdown__opener')]"), "Button DropDown");
    private CustomDropDown ddDomain = getElementFactory().getCustomElement(CustomDropDown::new, By.xpath("//*[@class='dropdown__list']"), "DropDown");
    private IButton buttonNext = getElementFactory().getButton(By.xpath("//*[contains(@class, 'button--secondary') and text()='Next']"), "Button Next in form login");
    private ICheckBox checkboxAcceptTerms = getElementFactory().getCustomElement(CustomCheckBox::new, By.xpath("//*[contains(@class, 'icon icon-check checkbox__check')]"), "CheckBox accept terms conditions");

    public LoginForm(){
        super(By.xpath("//*[contains(@class, 'login-form')]"), "Login form");
    }

    public void setPassword(String value){
        txbPassword.clearAndType(value);
    }

    public void setEmail(String value){
        txbEmail.clearAndType(value);
    }

    public void setDomain(String value){
        txbDomain.clearAndType(value);
    }

    public void setDomainSuffix(){
        buttonDropDown.click();
        ddDomain.selectByText();
    }

    public void uncheckCheckBoxAcceptTerms(){
        checkboxAcceptTerms.toggle();
    }

    public void clickButtonNext(){
        buttonNext.click();
    }
}
