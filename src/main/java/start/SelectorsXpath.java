package start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorsXpath {
    WebDriver driver = new ChromeDriver();

    @Test
    public void phoneBookTests(){
        driver.get("https://telranedu.web.app/home");
        driver.manage().window().maximize();
        pause(1000);
        // @ -> attribute (e.g. name)
        // = -> full match (e.g. @name = 'email')
        WebElement btnAbout = driver.findElement(By.xpath
                ("//a[@href='/about']"));
        btnAbout.click();
        pause(1000);
        System.out.println(btnAbout.isEnabled());
        System.out.println(btnAbout.isDisplayed());

        // find element by text; * -> any element
        WebElement btnLogin = driver.findElement(By.xpath
                ("//*[text() = 'LOGIN']"));
        btnLogin.click();
        pause(1000);

        // contains()... -> partial match
        WebElement inputEmail = driver.findElement(By.xpath
                ("//div/form/input[contains(@name, 'em')]"));
        // input data into the forms
        inputEmail.sendKeys("fisher.sar@gmail.com");
        pause(1000);

        // input[n] e.g. input[1], input[last()]
        WebElement inputPassword = driver.findElement(By.xpath
                ("//div/form/input[2]"));
        inputPassword.sendKeys("Qwerty1$");
        pause(1000);

        // list of elements
        List<WebElement> buttons = driver.findElements(By.xpath
                ("//button"));
        System.out.println(buttons);
        System.out.println(buttons.get(0).getText()); // login
        buttons.get(1).click();

        pause(5000);
        driver.quit();
    }

    @Test
    public void ilCarroXPathTest(){
        driver.manage().window().maximize();
        driver.get("https://ilcarro.web.app/registration?url=%2Fsearch");
        pause(1000);
        // //input[@id='name']/../../../.. выше по ветке

        WebElement el6 = driver.findElement(By.xpath
                ("//input[@id='name']/../../../../h2"));
        System.out.println(el6.getText()); // Type your data and hit Yalla!

        WebElement inputFirstName = driver.findElement(By.xpath
                ("//input[@id='name']"));
        inputFirstName.sendKeys("Sergey");
        pause(3000);
/*
WebElement el1 = driver.findElement(By.cssSelector
                ("[formcontrolname='firstName']"));
        WebElement el2 = driver.findElement(By.xpath
                ("//*[@formcontrolname='firstName']"));
        WebElement el3 = driver.findElement(By.cssSelector
                ("[formcontrolname^='first']"));
        WebElement el4 = driver.findElement(By.xpath
                ("//*[starts-with(@formcontrolname,'first')]"));
        WebElement el5 = driver.findElement(By.xpath
                ("//input[@formcontrolname='firstName']"));
 */



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
