import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

public class AutoTest {
    private WebDriver driver;
    private final String str = getClass().getName();
    void create() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        //允许访问所有链接
        options.addArguments("--remote-allow-origins=*");

        //1、打开浏览器
        driver = new ChromeDriver(options);

        //隐式等待 只用于查找元素是否存在 作用于全局
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //2.输⼊百度⽹址:https://www.baidu.com
        driver.get("https://www.baidu.com");
    }
    void test1() throws InterruptedException {
        create();
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

    void getScreen(String str) throws IOException {
        //./src/test/image/2025-12-26/AutoTest-190101.png
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat s2 = new SimpleDateFormat("HHmmssSS");//SS代表毫秒

        String fileName = "./src/test/image/" + s1.format(System.currentTimeMillis()) + "/" + str + "-" + s2.format(System.currentTimeMillis()) + ".png";
        File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screen,new File(fileName));

    }
    void  test2() throws IOException {
        create();
        driver.findElement(By.cssSelector("#chat-textarea")).sendKeys("迪丽热巴");
        getScreen(str);
        driver.quit();
    }

}
