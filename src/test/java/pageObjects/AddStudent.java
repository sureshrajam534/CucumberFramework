package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import applicationUtilities.Action;
import applicationUtilities.ApplicationUtilities;
import applicationUtilities.SelectCheckBox;
import generalUtilities.Halt;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXl;
import generalUtilities.SelectVisibleText;
import testSuites.TestSuites;

public class AddStudent {
	WebDriver driver;
	JavascriptExecutor js;
	ReadProperties myProp;
	ApplicationUtilities myUtils;
	ReadXl myXl;
	public static String env;
	public static String sname;
	List<WebElement> elements;
	Action parentAction;
	String text;
	WebElement element;
	List<WebElement> columns;
	Halt TS;
	Actions ClickListener;
	WebElement drpselect, drpselect1, drpselect2, drpselect3, drpselect4;
	Select dropdown, dropdown1, dropdown2, dropdown3, dropdown4;
	String ExamType;
	SelectCheckBox selectitem;
	SelectVisibleText vistext;
	

	public AddStudent(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myProp = new ReadProperties(TestSuites.configFilePath);
		env = myProp.readValue("environment");
		myUtils = new ApplicationUtilities(driver);
		myXl = new ReadXl(TestSuites.xlFilePath);
		parentAction = new Action(driver);
		TS = new Halt();
		ClickListener = new Actions(driver);
		selectitem = new SelectCheckBox(driver);
		vistext = new SelectVisibleText(driver);
		
	}

	public void addStudent() {
		// Add Student Module
		//TS.staticWait(2);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 100)");
		myUtils.returnElement("xpath", "//a[@href='load-studentform']//img[@id='rcorners2']").click();
		myUtils.returnElement("id", "firstname").sendKeys(myXl.getCellData(env, 18, 1));
		myUtils.returnElement("id", "lastname").sendKeys(myXl.getCellData(env, 19, 1));
		myUtils.returnElement("id", "username").sendKeys(myXl.getCellData(env, 20, 1));
		myUtils.returnElement("id", "password").sendKeys(myXl.getCellData(env, 21, 1));
		drpselect = driver.findElement(By.id("statename"));
		dropdown = new Select(drpselect);
		dropdown.selectByVisibleText(myXl.getCellData(env, 22, 1));
		//TS.staticWait(1);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drpselect1 = driver.findElement(By.id("locationidval"));
		dropdown1 = new Select(drpselect1);
		dropdown1.selectByVisibleText(myXl.getCellData(env, 23, 1));
		//TS.staticWait(1);
		drpselect2 = driver.findElement(By.id("branchidval"));
		dropdown2 = new Select(drpselect2);
		dropdown2.selectByVisibleText(myXl.getCellData(env, 24, 1));
		//TS.staticWait(1);
		drpselect3 = driver.findElement(By.id("classidval"));
		dropdown3 = new Select(drpselect3);
		dropdown3.selectByVisibleText(myXl.getCellData(env, 9, 1));
		//TS.staticWait(1);
		drpselect4 = driver.findElement(By.id("sectionidval"));
		dropdown4 = new Select(drpselect4);
		dropdown4.selectByVisibleText(myXl.getCellData(env, 10, 1));
		js.executeScript("window.scrollBy(0, 300)");
		myUtils.returnElement("id", "emailid").sendKeys(myXl.getCellData(env, 25, 1));
		//TS.staticWait(1);
		myUtils.returnElement("id", "Mobile").sendKeys(myXl.getCellData(env, 26, 1));
		myUtils.returnElement("className", "btn-primary").click();
		// myUtils.returnElement("xpath", "//a[contains(text(),'DASHBOARD')]").click();
		
		
	}

}
