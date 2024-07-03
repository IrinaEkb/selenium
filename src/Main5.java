import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.NoSuchElementException;

public class Main5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.navigate().to("https://practice.expandtesting.com/tables");

        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        double expectedTotal = 251.0;
        double actualTotal = getTotalAmountOfDueColumn(driver);

        if (actualTotal == expectedTotal) {
            System.out.println("TEST: PASSED");
        } else {
            System.out.println("TEST: FAILED");
        }

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() >= 2) {
                String lastName = columns.get(0).getText();
                String firstName = columns.get(1).getText();
                printEmailByFullName(driver, firstName, lastName);
            }
        }

    }
    public static void printEmailByFullName(WebDriver driver, String fName, String lName) {

            String xPath = String.format("//tr[td[text()='%s'] and td[text()='%s']]/td[3]", lName, fName);
            try {
                WebElement emailElement = driver.findElement(By.xpath(xPath));
                System.out.println("Email: " + emailElement.getText());
            } catch (NoSuchElementException e) {
                System.out.println("No such record found in table.");
            }

    }

    public static double getTotalAmountOfDueColumn(WebDriver driver) {

        double totalDue = 0.0;
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> columns = row.findElements(By.tagName("td"));
            if (columns.size() >= 4) {
                String dueAmount = columns.get(3).getText().replace("$", "").trim();
                try {
                    double due = Double.parseDouble(dueAmount);
                    totalDue += due;
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing due amount: " + dueAmount);
                }
                }

            }
        return totalDue;
        }


    }

