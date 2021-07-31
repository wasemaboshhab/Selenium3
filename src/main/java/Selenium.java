import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Scanner;


public class Selenium {
    public static void main(String[] args) {
        Account userAccount = new Account();
        userAccount.initUsernameAndPassword();
        ChromeDriver driver = openSite();
        try {
            findPersonalInfo(driver);
            typeStudentInformationAndLogin(driver , userAccount);
            Thread.sleep(1000);
            enterToMoodleSite(driver);
            Thread.sleep(2000);
            showAs_aCourseSummary(driver);
            Thread.sleep(2000);
            findCurrentCourses(driver);
            Thread.sleep(2000);
            leftMoodle(driver);
            Thread.sleep(2000);
            logOut(driver);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ChromeDriver openSite() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\user\\Desktop\\webdriver\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aac.ac.il/");
        WebElement menu = driver.findElement(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));
        return driver;
    }
    public static void findPersonalInfo(ChromeDriver driver) {
        WebElement menu = driver.findElement(By.id("menu-%d7%9b%d7%9c%d7%9c%d7%99"));
        List<WebElement> menuItems = menu.findElements(By.tagName("li"));
        WebElement personalInfo = menuItems.get(Deff.PERSONAL_INFORMATION);
        personalInfo.click();
    }
    public static void typeStudentInformationAndLogin(ChromeDriver driver, Account userAccount) {
        WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
        WebElement userPasswordInput = driver.findElement(By.id("Ecom_Password"));
        userNameInput.sendKeys(userAccount.getUsername());
        userPasswordInput.sendKeys(userAccount.getUserPassword());
        WebElement enterButton = driver.findElement(By.id("wp-submit"));
        enterButton.click();
    }
    public static void enterToMoodleSite(ChromeDriver driver) {
        List<WebElement> personalInfo_Options = driver.findElements(By.className("row"));
        WebElement modelRow = personalInfo_Options.get(5);
        WebElement modelButton = modelRow.findElement(By.tagName("a"));
        modelButton.click();
        WebElement container = driver.findElement(By.id("region-main"));
        List<WebElement> menuShow = container.findElements(By.className("d-sm-inline-block"));
        menuShow.get(Deff.COURSE_PRESENTATION).click();
        List<WebElement> styleOptions =container.findElements(By.tagName("a"));
        styleOptions.get(Deff.SUMMARY_OF_THE_COURSES).click();
    }
    public static void showAs_aCourseSummary(ChromeDriver driver) {
        WebElement container = driver.findElement(By.id("region-main"));
        List<WebElement> menuShow = container.findElements(By.className("d-sm-inline-block"));
        menuShow.get(Deff.COURSE_PRESENTATION).click();
        List<WebElement> styleOptions =container.findElements(By.tagName("a"));
        styleOptions.get(Deff.SUMMARY_OF_THE_COURSES).click();
    }
    public static void findCurrentCourses(ChromeDriver driver) {
        WebElement cursesButton = driver.findElement(By.id("page-container-2"));
        List<WebElement> coursesList = cursesButton.findElements(By.tagName("h6"));
        printCoursesList(coursesList);
        coursesList.get(checkChoice(coursesList.size())).click();
    }
    private static int checkChoice( int courseSize) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\n\tSelect Course 1 - "+ courseSize+"\n> ");
        int userChoice = scanner.nextInt();
        while (userChoice < 1 || userChoice > courseSize) {
            System.out.println("invalid Choice, please try again");
            userChoice = scanner.nextInt();
        }
        return userChoice-1;
    }
    public static void printCoursesList(List<WebElement> coursesList) {
        System.out.println("The amount of the courses are: " + coursesList.size() +"\nList of the courses: ");
        for (int i = 0; i < coursesList.size(); i++) {
            System.out.println("--------------------------------------------------------------------------------------\n");
            System.out.println(i+1+":");
            System.out.println(coursesList.get(i).getText());
        }

    }
    public static void logOut(ChromeDriver driver) {
        WebElement menu_topHeader = driver.findElement(By.id("menu-top-header"));
        List<WebElement> topHeaderOptions = menu_topHeader.findElements(By.tagName("li"));
        topHeaderOptions.get(Deff.LOGOUT).click();
    }
    public static void leftMoodle(ChromeDriver driver) {
        WebElement action_menu = driver.findElement(By.id("action-menu-1-menubar"));
        action_menu.click();
        WebElement logout = action_menu.findElement(By.id("actionmenuaction-6"));
        logout.click();
    }

}
