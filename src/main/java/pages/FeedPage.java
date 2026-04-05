package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FeedPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By coursesIcon = By.id("header-courses");

    public FeedPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickCoursesIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(coursesIcon)).click();
    }
}
