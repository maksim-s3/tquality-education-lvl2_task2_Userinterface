package aquality.selenium.template.custom_elements;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.CheckBox;
import aquality.selenium.elements.interfaces.IElement;
import org.openqa.selenium.By;

public class CustomCheckBox extends CheckBox {
    public CustomCheckBox(By locator, String name, ElementState state) {
        super(locator, name, state);
    }

    public void toggle() {
        this.click();
    }
}
