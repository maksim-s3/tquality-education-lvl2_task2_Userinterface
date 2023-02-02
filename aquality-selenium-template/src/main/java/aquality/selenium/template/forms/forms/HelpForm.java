package aquality.selenium.template.forms.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {
    private IButton hideButton = getElementFactory().getButton(By.xpath("//*[contains(@class, 'help-form__send-to-bottom-button')]"),
            "hide button help form");
    private ILabel label = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'help-form__title')]"), "Title help form");

    public HelpForm() {
        super(By.xpath("//*[contains(@class, 'help-form__container')]"), "Help form");
    }

    public void clickHideButton(){
        hideButton.click();
    }

    public boolean isFormHiden(){
        return label.state().waitForNotDisplayed();
    }
}
