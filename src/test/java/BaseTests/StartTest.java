package BaseTests;

import com.wallethub.Browsers.StartBrowserActions;
import com.wallethub.utils.Constant;
import org.testng.annotations.Test;

public class StartTest {
    @Test
    public void startBrowser() {
        StartBrowserActions startBrowser = new StartBrowserActions();
        startBrowser.openBrowser("chrome", Constant.URL);
    }
}
