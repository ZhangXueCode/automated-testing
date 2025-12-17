import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoTest {
    void test1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        //允许访问所有链接
        options.addArguments("--remote-allow-origins=*");

        //1、打开浏览器
        WebDriver driver = new ChromeDriver(options);

        //2.输⼊百度⽹址:https://www.baidu.com
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
        //3、找到输⼊框并输⼊“迪丽热巴”
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("迪丽热巴");
        Thread.sleep(2000);
        //4、找到“百度⼀下”按钮并点击
        driver.findElement(By.cssSelector("body")).click();
        Thread.sleep(2000);
        //5、关闭浏览器
        driver.quit();

    }
}
