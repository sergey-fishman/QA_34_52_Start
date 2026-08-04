/*
В проекте QA34_52_Start написать  тест в классе Home_Work_2
Вам необходимо найти и применить 15 локаторов для проекта ILCarro используя xPath для поиска
 */
package start;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class HomeWork2 {
    WebDriver driver = new ChromeDriver();

    @Test
    public void ilCarroXpath(){
        driver.manage().window().maximize();
        driver.get("https://ilcarro.web.app/search");
        pause(1000);

        //1. *[@class=' ' and text()=' ']
        WebElement linkLetTheCarWork = driver.findElement(By.xpath
                ("//a[@class='navigation-link' and text()=' Let the car work ']"));
        linkLetTheCarWork.click();
        pause(1000);

        //2. input location
        WebElement inputLocation = driver.findElement(By.xpath
                        ("//form/div[1]/input"));
        inputLocation.sendKeys("dudu-dotan 5, rishon le zion israel");

        //3. input manufacture with back tracking /../..
        WebElement inputManufacture = driver.findElement(By.xpath
                ("//form/div[1]/input/../../div[3]/input"));
        inputManufacture.sendKeys("VolksWagen");


        //4. input model with double back tracking /../.. /../..
        WebElement inputModel = driver.findElement(By.xpath
                ("//form/div[1]/input/../../div[3]/input/../../div[4]/input"));
        inputModel.sendKeys("Polo Sedan 1.6");

        //5. input year by //*[@id=' ']
        WebElement inputYear = driver.findElement(By.xpath
                ("//*[@id='year']"));
        inputYear.sendKeys("1996");

        //6. input fuel -> option diesel by contains(text()) //tag[contains(.,' ')]
        WebElement optionDiesel = driver.findElement(By.xpath
                ("//option[contains(.,'Dies')]"));
        optionDiesel.click();

        //7. input seats full xPath
        WebElement inputSeats = driver.findElement(By.xpath
                ("/html/body/app-root/app-navigator/app-let-car-work/div/form/div[7]/input"));
        inputSeats.sendKeys("4");

        //8. textArea unique element //element
        WebElement textArea = driver.findElement(By.xpath
                ("//textarea"));
        textArea.sendKeys("I am the text area!\n".repeat(10));
        pause(2000);

        //9. link Rome //a[text()=' ']
        WebElement linkRome = driver.findElement(By.xpath
                ("//a[text()='Rome']"));
        linkRome.click();
        pause(2000);

        //10. link Berlin -> //app-footer/div/div[4]/div/a[8]
        WebElement linkBerlin = driver.findElement(By.xpath
                ("//app-footer//a[8]"));
        linkBerlin.click();
        pause(1000);

        //11. link footer Sign up with a[contains(@href=' ... ')]
        WebElement linkRegiFooter = driver.findElement(By.xpath
                ("//app-footer//a[contains(@href,'regi')]"));
        linkRegiFooter.click();
        pause(1000);

        //12. checkbox class container
        WebElement inputCheckBox = driver.findElement(By.xpath
                ("//div[contains(@class, 'checkbox')]"));
        inputCheckBox.click();
        pause(1000);







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
