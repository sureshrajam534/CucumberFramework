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

public class DeleteLecturer {
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

	public DeleteLecturer(WebDriver driver)
	{
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
	public void deleteLecturer()
	{
		js = (JavascriptExecutor) driver;
		myUtils.returnElement("xpath", "//a[contains(text(),'DELETE LECTURER')]").click();
		myUtils.returnElement("id", "selectloc1").click();
		js.executeScript("window.scrollBy(0, 500)");
		myUtils.returnElement("id", "popup").click();
		myUtils.returnElement("xpath", "//button[@value='finishtest']").click();
		myUtils.returnElement("xpath", "//a[contains(text(),'DASHBOARD')]").click();
		
	}
	
}
