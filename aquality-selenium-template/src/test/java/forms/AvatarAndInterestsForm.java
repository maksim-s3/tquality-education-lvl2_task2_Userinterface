package forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import custom_elements.CustomCheckBox;
import aquality.selenium.template.utilities.FileHelper;
import aquality.selenium.template.utilities.Random;
import aquality.selenium.template.utilities.RobotUtil;
import org.openqa.selenium.By;
import java.util.List;

public class AvatarAndInterestsForm extends Form {
    private static final String FILE_AVATAR_NAME = "avatar.png";
    private ILabel pageIndicator = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'page-indicator')]"), "Page indicator");
    private IButton uploadButton = getElementFactory().getButton(By.xpath("//a[contains(@class, 'upload-button')]"), "Upload");
    private IButton nextButton = getElementFactory().getButton(By.xpath("//*[contains(text(), 'Next')]"), "Next");
    private By checkBoxsInterests = By.xpath("//input[not(contains(@id, 'select'))]//following-sibling::*");
    private CustomCheckBox customCheckBoxUnselectAll = getElementFactory().getCustomElement(CustomCheckBox::new,
            By.xpath("//*[@for='interest_unselectall']"), "Unselect all");

    public AvatarAndInterestsForm() {
        super(By.xpath("//*[@class='avatar-and-interests-page']"), "Avatar and interests form");
    }

    public int getPageIndicator(){
        return Integer.parseInt(pageIndicator.getText().substring(0, 1));
    }

    public void uncheckCheckBoxAllInterests() {
        customCheckBoxUnselectAll.toggle();
    }

    public void checkNumberRandomInterest(int numberInterest) {
        List<CustomCheckBox> listInterestCheckBoxs = getElementFactory().findElements(checkBoxsInterests, CustomCheckBox.class);
        for (int i = 0; i < numberInterest; i++) {
            int index = Random.getRandomIntNumber(0, listInterestCheckBoxs.size() - 1);
            listInterestCheckBoxs.get(index).toggle();
            listInterestCheckBoxs.remove(index);
        }
    }

    public void uploadImage() {
        uploadButton.click();
        String filePath = FileHelper.getResourceFileByName(FILE_AVATAR_NAME).getAbsolutePath();
        RobotUtil.sendTextInModalWindow(filePath);
    }

    public void clickNextButton() {
        nextButton.click();
    }
}
