package start;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorsXpath {
    WebDriver driver = new ChromeDriver();

    @Test
    public void phoneBookTests(){
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();











        pause(2000);
        driver.quit();

    }
    public void pause(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
