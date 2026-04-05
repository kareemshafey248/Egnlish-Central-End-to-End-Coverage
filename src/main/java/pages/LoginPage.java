package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By signInButton = By.id("sign-in-button");
    private By googleLoginButton = By.cssSelector("iframe[title='Sign in with Google Button']");
    // This is often inside an iframe or uses a specific button once clicked.
    // Given the subagent's finding, I'll use wait and switch if needed.

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }

    public void clickGoogleIcon() {
        // Switching to iframe if necessary
        try {
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(googleLoginButton));
            driver.switchTo().frame(iframe);
            driver.findElement(By.xpath("//div[@id='container']")).click(); // Example inner click
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            // Fallback or retry
            System.out.println("Google icon click failed: " + e.getMessage());
        }
    }
}
