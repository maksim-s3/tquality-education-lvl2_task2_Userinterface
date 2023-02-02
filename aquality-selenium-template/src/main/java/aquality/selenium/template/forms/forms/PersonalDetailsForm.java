package aquality.selenium.template.forms.forms;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {
    public PersonalDetailsForm() {
        super(By.xpath("//*[@class='personal-details__form']"), "Personal Details Form");
    }


}
