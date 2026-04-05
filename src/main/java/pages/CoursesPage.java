package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CoursesPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By socialIcon = By.xpath("//button[contains(text(), 'Social')]");
    private By levelDropdown = By.id("all-levels-dropdown");
    private By beginnerFilter = By.cssSelector(".difficulty-selector.beginner-after");
    private By intermediateFilter = By.cssSelector(".difficulty-selector.intermediate-after");
    private By advancedFilter = By.cssSelector(".difficulty-selector.advanced-after");
    private By courseCards = By.cssSelector(".c-thumbnail-wrapper");
    private By unitLink = By.tagName("ec-course-unit-activity");

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSocialIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(socialIcon)).click();
    }

    public void filterByLevel(String level) {
        wait.until(ExpectedConditions.elementToBeClickable(levelDropdown)).click();
        By filter;
        switch (level.toLowerCase()) {
            case "beginner": filter = beginnerFilter; break;
            case "intermediate": filter = intermediateFilter; break;
            case "advanced": filter = advancedFilter; break;
            default: throw new IllegalArgumentException("Unknown level: " + level);
        }
        wait.until(ExpectedConditions.elementToBeClickable(filter)).click();
    }

    public boolean isCourseListDisplayed() {
        List<WebElement> courses = driver.findElements(courseCards);
        return !courses.isEmpty();
    }

    public void selectFirstCourse() {
        wait.until(ExpectedConditions.elementToBeClickable(courseCards)).click();
    }

    public void selectFirstUnit() {
        wait.until(ExpectedConditions.elementToBeClickable(unitLink)).click();
    }
}
