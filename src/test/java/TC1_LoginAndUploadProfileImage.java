import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TC1_LoginAndUploadProfileImage {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Story("test verify sign in")
    @Description("this is Allure description")
    @Severity(SeverityLevel.NORMAL)
    @Test(dataProvider = "testdata")
    public void loginAndUploadProfileImage(String username, String passw) {
        LoginPage login = new LoginPage(driver);
        login.gotoSite();
        login.waitForLoginPanel();
        login.writeLogin(username);
        login.writePassword(passw);
        login.clickLoginButton();
        login.gotoSiteForUpload();
        login.uploadImage();
    }

    @DataProvider(name="testdata")
    public Object[][] getData() {
        Object[][] data = new Object[5][2];

        data[0][0] = "John";
        data[0][1] = "qwerty1";

        data[1][0] = "Peter";
        data[1][1] = "qwerty2";

        data[2][0] = "Mark";
        data[2][1] = "qwerty3";

        data[3][0] = "Maxime";
        data[3][1] = "qwerty4";

        data[4][0] = "Derek";
        data[4][1] = "qwerty5";

        return data;
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
