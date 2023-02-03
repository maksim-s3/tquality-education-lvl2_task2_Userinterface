package forms.pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GamePage extends Form {
    private ILabel timer = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'timer')]"), "Timer");

    public GamePage() {
        super(By.xpath("//*[contains(@class, 'game view')]"), "Game page");
    }

    public String getTimer() {
        return timer.getText();
    }
}
