package aquality.selenium.template.forms.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {
    private IButton buttonAcceptCookies = getElementFactory().getButton(By.xpath("//*[contains(@class, 'button--transparent')]"), "Button Accept Cookies");

    public CookiesForm() {
        super(By.xpath("//*[@class='cookies']"), "Cookies form");
    }

    public void acceptCookies(){
        buttonAcceptCookies.click();
    }
}
