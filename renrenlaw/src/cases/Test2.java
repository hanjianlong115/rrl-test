package cases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Test2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeTest
  (alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://101.201.143.237/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitled() throws Exception {
    driver.get(baseUrl + "/ask");
    driver.findElement(By.linkText("��¼")).click();
    driver.findElement(By.name("password")).sendKeys("hjl19901012");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("18810352600");
    driver.findElement(By.linkText("������¼")).click();
    Thread.sleep(3000);
    /*���ü��㣬����Ƿ����ҵ�"��ӭ����  ������  |  ��������  "*/
    assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/a[1]")).getText(), "��ӭ����  ������  |  ��������  ");
   // driver.switchTo().alert().accept();
    //(driver.findElement(By.linkText("��ӭ����  ������  |  ��������")).getText(), "��ӭ����  ������  |  ��������");
  }

  @AfterTest(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
