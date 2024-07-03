import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class Main4 {
public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    Thread.sleep(3000);
    driver.get("https://demowebshop.tricentis.com");
    driver.manage().window().maximize();

    driver.findElement(By.cssSelector("a[class='ico-register']")).click();
    driver.navigate().back();
    driver.findElement(By.cssSelector("a[class=\"ico-login\"]")).click();
    driver.navigate().back();
    driver.findElement(By.cssSelector("input[id='small-searchterms']")).click();
    driver.navigate().back();
    driver.findElement(By.cssSelector("a[class='ico-register']")).click();
    driver.navigate().back();

}











}
