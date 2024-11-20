

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        String path = System.getProperty("user.dir"); 
        System.setProperty("webdriver.chrome.driver", path + "\\src\\driver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.quit();

        
                
    }
}
