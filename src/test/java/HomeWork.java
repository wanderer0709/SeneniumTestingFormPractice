import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWork {

    public static void main(String[] args) throws IllegalStateException {
        String path = System.getProperty("user.dir");

        System.setProperty("webdriver.chrome.driver", path + "/libs/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        driver.manage().window().maximize();

        WebElement fName = driver.findElement(By.id("firstName"));
        fName.sendKeys("Son");
        WebElement lName = driver.findElement(By.id("lastName"));
        lName.sendKeys("Nguyen");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("abc@gmail.com");
        WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));
        gender.click();
        WebElement mobile = driver.findElement(By.id("userNumber"));
        mobile.sendKeys("0985643212");

        // Select date 03/04/1993 from the DatePicker
        WebElement selectDate = driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
        selectDate.click();
        Select month = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByValue("3");
        Select year = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByValue("1993");
        WebElement day = driver.findElement(By.xpath("//div[@aria-label='Choose Saturday, April 3rd, 1993']"));
        day.click();

        // Choosing subjects
        WebElement subject = driver.findElement(By.xpath("//input[@id='subjectsInput']"));
        subject.sendKeys("English");
        subject.sendKeys(Keys.RETURN);
        subject.sendKeys("History");
        subject.sendKeys(Keys.RETURN);

        // Choose hobby
        WebElement hobby = driver.findElement(By.xpath("//label[contains(text(),'Reading')]"));
        // Use javascript code to scroll down because Google overlap with the element
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", hobby);
        hobby.click();

        // Choose address
        WebElement address = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        address.sendKeys("148 Nguyen Khoai Street, Hai Ba Trung District, Hanoi");

        // Choose state and city
        WebElement state = driver.findElement(By.xpath("//input[@id='react-select-3-input']"));
        state.sendKeys("NCR");
        state.sendKeys(Keys.RETURN);
        WebElement city = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        city.sendKeys("Delhi");
        city.sendKeys(Keys.RETURN);

        // Press Enter key again to submit form because the Submit button is hidden by footer
        city.sendKeys(Keys.RETURN);
//        WebElement submitBt = driver.findElement(By.xpath("//button[@id='submit']"));
//        Actions action = new Actions(driver);
//        action.moveToElement(submitBt).click().build().perform();

        driver.close();

    }
}
