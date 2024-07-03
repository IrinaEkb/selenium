import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Main2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Thread.sleep(3000);
        driver.get("https://demowebshop.tricentis.com");

        driver.manage().window().maximize();
        List<WebElement> options = driver.findElements(By.xpath("//div[@class = 'column customer-service']//li"));
        Thread.sleep(3000);


        System.out.println("Number of available options: " + options.size());

        driver.close();


    }
}
