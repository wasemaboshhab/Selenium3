import java.sql.ClientInfoStatus;
import java.sql.SQLOutput;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.lang.model.util.Elements;
import java.util.List;

public class Selenium {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your userName :");
        String username = scanner.next();
        System.out.println("enter your password\n> :");
        String password = scanner.next();

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Desktop\\webdriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aac.ac.il/");
        WebElement menu = driver.findElement(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));

        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement personalInfo = menuItems.get(19);

        personalInfo.click();
        WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
        WebElement userPasswordInput = driver.findElement(By.id("Ecom_Password"));
        userNameInput.sendKeys(username); // <-- real username
        userPasswordInput.sendKeys(password); // <- password
        WebElement enter = driver.findElement(By.id("wp-submit"));
        try {
            Thread.sleep(500);
            enter.click();
            List<WebElement> personalInfo_Options = driver.findElements(By.className("row"));
            WebElement modelRow = personalInfo_Options.get(5);
            WebElement modelButton = modelRow.findElement(By.tagName("a"));
            Thread.sleep(500);
            modelButton.click();
        //fix
            WebElement container = driver.findElement(By.id("region-main"));
            List<WebElement> menuShow = container.findElements(By.className("d-sm-inline-block"));
            Thread.sleep(500);
            menuShow.get(2).click();
            Thread.sleep(500);
            List<WebElement> styleOptions =container.findElements(By.tagName("a"));
            styleOptions.get(12).click();






















                                 /*//COURSES_ELEMENTS*/

            List<WebElement> box = driver.findElements(By.className("d-flex"));

//              *********************
           System.out.println(box.size());
            for (int i = 0; i < box.size(); i++) {
            System.out.println("--------------------------------------------------------------------------------------");
                System.out.println("\n" + i);
                System.out.println(box.get(i).getText());
            }

        } catch (Exception e) {
            System.out.println("Exception...!!");
        }

    }
}
