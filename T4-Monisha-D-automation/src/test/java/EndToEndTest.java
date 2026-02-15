import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class EndToEndTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", 
                "C:\\Users\\YourName\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();

            // Open application
            driver.get("https://dev.octopussaas.com/");

            // Login
            driver.findElement(By.id("email")).sendKeys("henry@test.com");
            driver.findElement(By.id("password")).sendKeys("Nayan123@");
            driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();

            //  Login Validation
            if (driver.getCurrentUrl().contains("dashboard")) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Login Failed");
            }

            // Add New Generator
            driver.findElement(By.xpath("//button[contains(text(),'Add New')]")).click();
            driver.findElement(By.xpath("//span[text()='Generator']")).click();

            driver.findElement(By.name("generatorName"))
                    .sendKeys("Test Generator Automation");

            driver.findElement(By.name("internalAccountNumber"))
                    .sendKeys("INT-001");

            driver.findElement(By.xpath("//button[contains(text(),'Add New Generator')]"))
                    .click();

            // Assign Route
            driver.findElement(By.xpath("//button[contains(text(),'Route Assignment')]"))
                    .click();

            driver.findElement(By.xpath("//button[contains(text(),'Add Service')]"))
                    .click();

            // Update Price Book
            driver.findElement(By.xpath("//button[contains(text(),'Price Book')]"))
                    .click();

            driver.findElement(By.name("price")).clear();
            driver.findElement(By.name("price")).sendKeys("500");

            driver.findElement(By.xpath("//button[contains(text(),'Save')]"))
                    .click();

            // Logout
            driver.findElement(By.xpath("//div[contains(text(),'HB')]")).click();
            driver.findElement(By.xpath("//button[contains(text(),'Logout')]")).click();

        } catch (Exception e) {

            System.out.println("Test Failed: " + e.getMessage());

        } finally {

            driver.quit();
        }
    }
}
