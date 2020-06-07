import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private String baseUrl = "https://opensource-demo.orangehrmlive.com/index.php/auth/login";

    By LoginPanel = By.xpath("//div[text()='LOGIN Panel']");
    By loginField = By.xpath("//input[@id='txtUsername']");
    By passField = By.xpath("//input[@id='txtPassword']");
    By buttonLogin = By.xpath("//input[@id='btnLogin' and @name='Submit']");
    By userDashboard = By.xpath("//h1[text()='Dashboard']");
    By uploadImageText = By.xpath("//div[@id='uploadwindow']/span/b[text()='Select file to send(max 196.45 MB)']");
    By uploadImageField = By.id("uploadfile_0");

    public LoginPage gotoSite(){
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        return new LoginPage(driver);
    }

    public LoginPage gotoSiteForUpload(){
        driver.get("http://demo.guru99.com/test/upload/");
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(uploadImageText));
        return new LoginPage(driver);
    }

    public LoginPage uploadImage(){
        driver.findElement(uploadImageField).sendKeys("C:\\moment.jpg");
        return new LoginPage(driver);
    }


    public LoginPage writeLogin(String username){
        driver.findElement(loginField).sendKeys(username);
        return new LoginPage(driver);
    }

    public LoginPage writePassword(String passw) {
        driver.findElement(passField).sendKeys(passw);
        return new LoginPage(driver);
    }
    public LoginPage clickLoginButton(){
        driver.findElement(buttonLogin).click();
        return new LoginPage(driver);
    }
    public LoginPage waitForDashboard() {
       new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(userDashboard));
        return new LoginPage(driver);
    }

    public LoginPage waitForLoginPanel() {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(LoginPanel));
        return new LoginPage(driver);
    }


}
