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

public class ModifyState {
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
	WebElement mySelectElement, drpselect;
	Select dropdown;
	String ExamType;
	SelectCheckBox selectitem;
	SelectVisibleText vistext;

	public ModifyState(WebDriver driver) {
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

	public void modifyState() {
		myUtils.returnElement("xpath", "//a[@href='load-stateform']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//a[@href='load-EditStateform']").click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		myUtils.returnElement("id", "categorylist6.statename").clear();
		myUtils.returnElement("id", "categorylist6.statename").sendKeys(myXl.getCellData(env, 38, 1));
		myUtils.returnElement("id", myXl.getCellData(env, 37, 1)).click();
		js.executeScript("window.scrollBy(0, 500)");
		myUtils.returnElement("xpath", "//button[@id='popup']").click();
		myUtils.returnElement("xpath", "//button[@value='finishtest']").click();
		myUtils.returnElement("xpath", "//a[contains(text(),'DASHBOARD')]").click();
	}

}
