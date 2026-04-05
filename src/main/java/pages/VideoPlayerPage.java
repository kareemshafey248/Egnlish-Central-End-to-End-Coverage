package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VideoPlayerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By settingsGear = By.cssSelector(".fa-cog");
    private By resolutionDropdown = By.id("dropdownResolution");
    private By res360p = By.xpath("//span[contains(text(), '360p')]");
    private By subtitlesToggle = By.cssSelector(".fa-commenting");
    private By videoElement = By.tagName("video");

    public VideoPlayerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isVideoPlayerOpen() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(videoElement)).isDisplayed();
    }

    public void changeResolutionTo360() {
        wait.until(ExpectedConditions.elementToBeClickable(settingsGear)).click();
        wait.until(ExpectedConditions.elementToBeClickable(resolutionDropdown)).click();
        wait.until(ExpectedConditions.elementToBeClickable(res360p)).click();
    }

    public void toggleSubtitles() {
        wait.until(ExpectedConditions.elementToBeClickable(subtitlesToggle)).click();
    }
}
