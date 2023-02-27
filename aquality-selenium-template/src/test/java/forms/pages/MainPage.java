package forms.pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class MainPage extends Form {
    private final ILink startLink = getElementFactory().getLink(By.xpath("//*[contains(@class, 'start__link')]"), "Click HERE to GO");

    public MainPage() {
        super(By.xpath("//*[contains(@class, 'start__paragraph')]"), "Main page");
    }

    public void clickStartLink() {
        startLink.click();
    }
}
