package forms;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {
    private ILabel pageIndicator = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'page-indicator')]"), "Page indicator");

    public PersonalDetailsForm() {
        super(By.xpath("//*[@class='personal-details__form']"), "Personal Details Form");
    }

    public int getPageIndicator(){
        return Integer.parseInt(pageIndicator.getText().substring(0, 1));
    }
}
