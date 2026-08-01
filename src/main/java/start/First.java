package start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class First {
    WebDriver driver = new ChromeDriver();


    @Test
    public void firstTest() {
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // получить новую страницу в браузере
        driver.get("https://telranedu.web.app/home");
        pause(1000);
        // поиск элемента по каскадной таблице стилей
        WebElement btnAbout =
                driver.findElement(By.cssSelector("a[href='/about']"));
        btnAbout.click();
        // навигация внутри сайта
        // driver.navigate().to("https://telranedu.web.app/home");
        // driver.get("https://telranedu.web.app/about");
        pause(1000); // milliseconds
        // навигация по браузеру
        driver.navigate().back();
        pause(1000);

        WebElement btnLogin =
                driver.findElement(By.cssSelector("a[href='/login']"));
        btnLogin.click();
        pause(1000);

//        driver.navigate().back();
//        pause(1000);
//
//        driver.navigate().forward();
//        pause(1000);
//
//        driver.navigate().refresh();
//        pause(1000);

        WebElement btnHome =
                driver.findElement(By.cssSelector("[href='/home']"));
        btnHome.click();
        pause(1000);
        WebElement divRoot =
                driver.findElement(By.cssSelector("div[id='root']"));
        // поиск по id
        // #root
        // [id='root']
        // *[id='root']
        System.out.println(divRoot.getTagName());// -> div
        System.out.println(divRoot.getAttribute("class"));// -> container

        WebElement divRoot1 =
                driver.findElement(By.id("root"));
        System.out.println(divRoot1.getTagName());
        System.out.println(divRoot1.getAttribute("class"));

        // по имени искать в целом не актуально, потому что имен много
        WebElement divRoot2 =
                driver.findElement(By.className("container"));
        System.out.println(divRoot2.getAttribute("id"));// -> root



        // закрыть вкладку браузера
        //driver.close();
        // закрыть браузер
        driver.quit();
    }

    @Test
    public void ilCarroTest(){
        driver.manage().window().maximize();
        driver.get("https://ilcarro.web.app/search");
        pause(1000);
        WebElement linkSearch =
                driver.findElement(By.cssSelector(".navigation-link"));
        // точка это поиск по классам, найдет первый попавшийся
        // a[class='navigation-link']
        // .navigation-link
        // *[class='navigation-link']
        // a[id='0']
        // #0
        // a#0.navigation-link
        // a#0.navigation-link[href='/search']
        linkSearch.click();
        pause(1000);

        WebElement linkTerms = driver.findElement(By.cssSelector
                ("a.navigation-link[href='/terms-of-use']"));
        // [href='/terms-of-use']
        // a[href*='/of-use'] * -> включает в себя
        // a[href^='/terms'] ^ -> начинается с...
        // a[href$='-use'] $ -> заканчивается на...
        linkTerms.click();
        pause(1000);

        WebElement linkSignUp = driver.findElement(By.cssSelector
                ("div.header a.navigation-link:nth-child(5)"));
        linkSignUp.click();
        pause(1000);

        WebElement linkLogin = driver.findElement(By.cssSelector
                ("div.header a.navigation-link:last-child"));
        linkLogin.click();
        pause(1000);
        // первый элемент не относится к navigation-link, поэтому:
        // div.header a:first-child либо div.header a:nth-child(1)

        WebElement logo = driver.findElement(By.cssSelector
                ("div.header a:first-child"));
        logo.click();
        pause(1000);

        WebElement linkLetTheCar = driver.findElement(By.linkText
                ("Let the car work"));
        linkLetTheCar.click();
        pause(1000);

        driver.navigate().back();
        pause(1000);

        WebElement linkLetTheCar1 = driver.findElement(By.partialLinkText
                ("work"));
        linkLetTheCar1.click();
        pause(1000);


        pause(1000);
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
