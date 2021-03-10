package BaseTests;

import com.facebook.Browsers.StartBrowserActions;
import com.facebook.utils.Constant;
import org.testng.annotations.Test;

public class StartTest {
    @Test
    public void startBrowser() {
        StartBrowserActions startBrowser = new StartBrowserActions();
        startBrowser.openBrowser("chrome", Constant.URL);
    }
}
