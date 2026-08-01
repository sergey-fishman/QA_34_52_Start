package start;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;


public class Homework1 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void phoneBook(){
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://telranedu.web.app/home");
        pause(1000);

        // Ищем первый элемент в navbar-component
        WebElement header1PhoneBook =
                driver.findElement(By.cssSelector("div.navbar-component_nav__1X_4m > h1"));
        System.out.println(header1PhoneBook.getText());

        // Home -> About
        WebElement btnAbout =
                driver.findElement(By.cssSelector("div.navbar-component_nav__1X_4m > a[href='/about']"));
        btnAbout.click();
        pause(1000);

        // About -> Home
        WebElement btnHome =
                driver.findElement(By.cssSelector("div.navbar-component_nav__1X_4m a:nth-child(2)"));
        btnHome.click();
        pause(1000);

        // Home -> Login
        WebElement btnLogin =
                driver.findElement(By.cssSelector("div.navbar-component_nav__1X_4m > a:last-child"));
        btnLogin.click();
        pause(1000);

        // button submitLogin
        WebElement btnSubmitLogin =
                driver.findElement(By.cssSelector("div.login_login__3EHKB form button[name='login']"));
        System.out.println("btnSubmitLogin getTagName = " + btnSubmitLogin.getTagName());
        System.out.println("btnSubmitLogin type = " + btnSubmitLogin.getAttribute("type"));
        System.out.println("btnSubmitLogin name = " + btnSubmitLogin.getAttribute("name"));
        System.out.println();

        // button submit Registration via button:nth-of-type
        WebElement btnSubmitReg =
                driver.findElement(By.cssSelector("div.login_login__3EHKB form button:nth-of-type(2)"));
        System.out.println("btnSubmitReg getTagName = " + btnSubmitReg.getTagName());
        System.out.println("btnSubmitReg type = " + btnSubmitReg.getAttribute("type"));
        System.out.println("btnSubmitReg name = " + btnSubmitReg.getAttribute("name"));
        pause(1000);

        // Login - Home
        driver.navigate().back();
        pause(1000);

        // text home component
        WebElement textHomeComponent =
                driver.findElement(By.cssSelector("div.container > div > div h1"));
        System.out.println(textHomeComponent.getText());

        // hide body
        hideBody();
        pause(1000);
        driver.navigate().refresh();
        pause(1000);
        driver.quit();
    }

    @Test
    public void ilCarro(){
        driver.manage().window().maximize();
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ilcarro.web.app/search");
        pause(1000);
        // search -> sign up
        WebElement btnSignUp =
                driver.findElement(By.cssSelector("div.header > a:nth-child(5)"));
        btnSignUp.click();
        pause(2000);

        // signup page -> login page via Join Now button
        WebElement btnJoinNow =
                driver.findElement(By.cssSelector("div.special-offers-container .login-btn"));
        btnJoinNow.click();
        pause(2000);

        // login page -> terms of use page via footer
        WebElement btnTermsOfUseFooter =
                driver.findElement(By.cssSelector("app-footer > div > div.page-links a:nth-child(3)"));
        btnTermsOfUseFooter.click();
        pause(2000);

        // terms od use page -> privacy policy page via link in the 5th paragraph
        // p:nth-of-type(5) a[href='/privacy-police']
        WebElement linkPrivacyPolicy = driver.findElement(By.cssSelector
                ("app-navigator div.terms-container p:nth-of-type(5) a[href='/privacy-police']"));
        linkPrivacyPolicy.click();
        pause(2000);

        // privacy policy -> home page via logo button
        WebElement btnLogo =
                driver.findElement(By.cssSelector("div.header a.logo"));
        btnLogo.click();
        pause(2000);

        WebElement linkRome =
                driver.findElement(By.cssSelector("app-footer a[href*='Rome']"));
        linkRome.click();
        pause(5000);

        // rome -> berlin при использовании implicitlyWait() виснет без причины
        WebElement linkBerlin =
                driver.findElement(By.partialLinkText("Berlin"));
        linkBerlin.click();
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

    public void hideBody(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('body').style.display = 'none'");
    }

    public void scrollActions(){
        Actions actions = new Actions(driver);
        for (int i = 0; i < 3; i++) {
            actions.scrollByAmount(0, 700).perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
