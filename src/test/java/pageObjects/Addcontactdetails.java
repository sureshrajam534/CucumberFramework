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

public class Addcontactdetails {
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
	public Addcontactdetails(WebDriver driver) {
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
	public void addContactDetails()
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 5500)");				
		myUtils.returnElement("xpath", "//a[@href='load-addContactdet']//img[@id='rcorners2']").click();
		myUtils.returnElement("id", "contactinfo").clear();
		myUtils.returnElement("id", "contactinfo").sendKeys(myXl.getCellData(env, 26, 1));
		myUtils.returnElement("id", "emailid").clear();
		myUtils.returnElement("id", "emailid").sendKeys(myXl.getCellData(env, 25, 1));
		myUtils.returnElement("id", "address").clear();
		myUtils.returnElement("id", "address").sendKeys(myXl.getCellData(env, 34, 1));
		myUtils.returnElement("className", "btn-primary").click();
		myUtils.returnElement("xpath", "//a[contains(text(),'DASHBOARD')]").click();
	}
}
