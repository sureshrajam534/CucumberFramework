package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import applicationUtilities.Action;
import applicationUtilities.ApplicationUtilities;
import applicationUtilities.SelectCheckBox;
import generalUtilities.Halt;
import generalUtilities.ReadProperties;
import generalUtilities.ReadXl;
import generalUtilities.SelectVisibleText;
import testSuites.TestSuites;

public class DeleteStudent {
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
	WebElement drpselect;
	Select dropdown;
	String ExamType;
	SelectCheckBox selectitem;
	SelectVisibleText vistext;
	
	public DeleteStudent(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myProp = new ReadProperties(TestSuites.configFilePath);
		env = myProp.readValue("environment");
		myUtils = new ApplicationUtilities(driver);
		myXl = new ReadXl(TestSuites.xlFilePath);
		parentAction = new Action(driver);
		TS = new Halt();
		selectitem = new SelectCheckBox(driver);
		vistext = new SelectVisibleText(driver);
		
	}
	
	public void deleteStudent()
	{
		//Delete Student Module
		//TS.staticWait(2);
		js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0, 100)");
		myUtils.returnElement("linkText", "DELETE STUDENT").click();
		//TS.staticWait(1);
		myUtils.returnElement("xpath", "//span[contains(text(),'--Please Select--')]").click();
		parentAction.singleKeyDown("xpath", "//span[contains(text(),'--Please Select--')]",
				"Electus", 9, 1);
		//TS.staticWait(2);
		drpselect = driver.findElement(By.id("selsectionid"));
		dropdown = new Select(drpselect);
		//TS.staticWait(1);
		dropdown.selectByVisibleText(myXl.getCellData(env, 10, 1));
		myUtils.returnElement("xpath", "//button[contains(text(),'Fetch Students')]").click();
		TS.staticWait(1);
		myUtils.returnElement("id", myXl.getCellData(env, 27, 1)).click();
		js.executeScript("window.scrollBy(0, 500)");
		myUtils.returnElement("xpath", "//button[contains(text(),'DELETE')]").click();
		//TS.staticWait(1);
		
		myUtils.returnElement("xpath",
				"//button[@value='finishtest']").click();
		myUtils.returnElement("xpath", "//a[contains(text(),'DASHBOARD')]").click();
		
//		Alert myalert = driver.switchTo().alert();
//		myalert.accept();
	}
}
