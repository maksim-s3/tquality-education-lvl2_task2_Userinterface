package aquality.selenium.template.utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    private ScreenshotProvider screenshotProvider = new ScreenshotProvider();

    public void onTestFailure(ITestResult result) {
        screenshotProvider.takeScreenshot();
    }

    public void onTestSuccess(ITestResult result){
        screenshotProvider.takeScreenshot();
    }
}
