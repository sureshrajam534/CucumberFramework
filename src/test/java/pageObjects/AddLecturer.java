package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class AddLecturer {
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
	WebElement mySelectElement;
	Select dropdown;
	String ExamType;
	SelectCheckBox selectitem;
	SelectVisibleText vistext;
	public AddLecturer(WebDriver driver) {
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
	public void addLecturer()
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 5000)");
		myUtils.returnElement("xpath", "//a[@href='load-lecturerform']//img[@id='rcorners2']").click();
		myUtils.returnElement("id", "firstname").sendKeys(myXl.getCellData(env, 28, 1));
		myUtils.returnElement("id", "lastname").sendKeys(myXl.getCellData(env, 29, 1));
		myUtils.returnElement("id", "username").sendKeys(myXl.getCellData(env, 30, 1));
		myUtils.returnElement("id", "password").sendKeys(myXl.getCellData(env, 31, 1));
		myUtils.returnElement("id", "emailid").sendKeys(myXl.getCellData(env, 32, 1));
		myUtils.returnElement("id", "mobile").sendKeys(myXl.getCellData(env, 33, 1));
		myUtils.returnElement("className", "btn-primary").click();
	}
}
