package aquality.selenium.template.utilities;

import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Attachment;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;
import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ScreenshotProvider implements IScreenshotProvider {
    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = ".png")
    public byte[] takeScreenshot() {
        int scrollTimeout = 100;
        ShootingStrategy shootingStrategy = ShootingStrategies.viewportPasting(scrollTimeout);
        Screenshot fpScreenshot = new AShot()
                .shootingStrategy(shootingStrategy)
                .takeScreenshot(AqualityServices.getBrowser().getDriver());

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(fpScreenshot.getImage(), "jpg", baos);
            baos.flush();
            return baos.toByteArray();
        } catch (IOException ioe) {
            AqualityServices.getLogger()
                    .debug("IO Exception during preparing screenshot of full page%nException message", ioe);
            return new byte[] {};
        }
    }
}
