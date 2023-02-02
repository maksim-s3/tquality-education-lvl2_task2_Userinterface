package aquality.selenium.template.forms.forms;

import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import aquality.selenium.template.custom_elements.CustomCheckBox;
import aquality.selenium.template.utilities.Random;
import org.openqa.selenium.By;

import java.util.List;

public class AvatarAndInterestsForm extends Form {
    private ICheckBox checkBoxUnselectAll = getElementFactory().getCheckBox(By.id("interest_unselectall"), "CheckBox unselect all");
    private CustomCheckBox customCheckBoxUnselectAll = getElementFactory().getCustomElement(CustomCheckBox::new,
            By.xpath("//*[@for='interest_unselectall']"), "CheckBox unselect all");

    public AvatarAndInterestsForm() {
        super(By.xpath("//*[@class='avatar-and-interests-page']"), "Avatar and interests form");
    }

    public void unselectAllInterests(){
        customCheckBoxUnselectAll.toggle();
    }

    public void checkNumberRandomInterest(int numberInterest){
        List<CustomCheckBox> listInterestCheckBoxs = getElementFactory().findElements(By.xpath("//*[contains(@class, 'checkbox__box')]"), CustomCheckBox.class);
        for(int i=0; i<numberInterest; i++){
            int index = Random.getRandomIntNumber(0, listInterestCheckBoxs.size()-2);
            listInterestCheckBoxs.get(index).toggle();
            listInterestCheckBoxs.remove(index);
        }
    }

    public void clickDownload(){

    }

}
