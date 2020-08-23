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

public class ModifyStudent {
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
	

	public ModifyStudent(WebDriver driver) {
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

	public void modifyStudent() {
		// Modify Student Module
		//TS.staticWait(2);
		js = (JavascriptExecutor) driver;
		// js.executeScript("window.scrollBy(0, 100)");
		myUtils.returnElement("linkText", "MODIFY STUDENT").click();
		myUtils.returnElement("xpath", "/html[1]/body[1]/div[5]/div[3]/div[1]/form[1]/div[1]/a[1]/span[1]").click();
		parentAction.singleKeyDown("xpath", "/html[1]/body[1]/div[5]/div[3]/div[1]/form[1]/div[1]/a[1]/span[1]",
				"Electus", 9, 1);
		//TS.staticWait(2);
		drpselect = driver.findElement(By.id("selsectionid"));
		dropdown = new Select(drpselect);
		//TS.staticWait(1);
		dropdown.selectByVisibleText(myXl.getCellData(env, 10, 1));
		myUtils.returnElement("xpath", "//button[contains(text(),'Fetch Students')]").click();
		TS.staticWait(2);
		myUtils.returnElement("id", "selectloc0").click();
		//TS.staticWait(1);
		myUtils.returnElement("id", "studentformlist0.firstname").clear();
		//TS.staticWait(1);
		myUtils.returnElement("id", "studentformlist0.firstname").sendKeys(myXl.getCellData(env, 18, 1));
		js.executeScript("window.scrollBy(0, 100)");
		//js.executeScript("document.querySelector('table th:last-child').scrollIntoView();");
		myUtils.returnElement("xpath", "//button[contains(text(),'UPDATE')]").click();
		//TS.staticWait(1);
		myUtils.returnElement("xpath",
				"/html[1]/body[1]/div[5]/div[2]/form[1]/div[4]/div[1]/table[1]/tbody[1]/tr[3]/td[1]/button[1]").click();
//		Alert myalert = driver.switchTo().alert();
//		myalert.accept();
	

	}
}
