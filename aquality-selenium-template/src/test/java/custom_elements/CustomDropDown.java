package custom_elements;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.ComboBox;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.template.utilities.Random;
import org.openqa.selenium.By;
import java.util.List;

public class CustomDropDown extends ComboBox {
    public CustomDropDown(By locator, String name, ElementState state) {
        super(locator, name, state);
    }

    public void selectByRandomIndex() {
        List<ITextBox> listItem = findChildElements(By.xpath("//*[contains(@class, 'dropdown__list')]"), ITextBox.class);
        int index = Random.getRandomIntNumber(0, listItem.size()-1);
        listItem.get(index).click();
    }
}
