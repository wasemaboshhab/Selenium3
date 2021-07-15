import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Selenium {
    public static void main(String[] args) {

//                Scanner scanner = new Scanner(System.in);
//        System.out.println("enter your userName :");
//        String username = scanner.next();
//        System.out.println("enter your password\n> :");
//        String password = scanner.next();

        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Desktop\\webdriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aac.ac.il/");
        WebElement menu = driver.findElement(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));

        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement personalInfo = menuItems.get(19);

        try {
            Thread.sleep(1000);
            personalInfo.click();
            WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
            WebElement userPassword = driver.findElement(By.id("Ecom_Password"));
            userNameInput.sendKeys("userName"); // <-- real username
            userPassword.sendKeys("Password"); // <- password
            WebElement enter = driver.findElement(By.id("wp-submit"));
            Thread.sleep(1000);
            enter.click();
            List<WebElement> personalInfo_Options = driver.findElements(By.className("row"));
            WebElement modelRow = personalInfo_Options.get(5);
            WebElement modelButton = modelRow.findElement(By.tagName("a"));
                    String modelUrl = modelButton.getAttribute("href");
//                    System.out.println(modelUrl);
            Thread.sleep(1000);
            modelButton.click();

                driver.get(modelUrl);


//                here we will try to found the courses name
            List<WebElement> courses = driver.findElements(By.className("multiline"));
            if (courses != null) {
                System.out.println(courses.size());

            }




        } catch (InterruptedException e) {

        }

    }
}
