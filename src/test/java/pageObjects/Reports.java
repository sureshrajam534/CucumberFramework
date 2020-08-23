package pageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Reports {
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

	public Reports(WebDriver driver) {
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

	public void reports() {
		myUtils.returnElement("xpath", "//a[@href='load-ExamNameReports']//img[@id='rcorners2']").click();
		ClickListener.moveToElement(myUtils.returnElement("xpath", "//span[contains(text(),'--Please Select--')]"))
				.click().sendKeys(myXl.getCellData(env, 46, 1)).sendKeys(Keys.ENTER).build().perform();
		myUtils.returnElement("xpath", "//button[@class='button btn-primary']").click();
		//All india marks analysis
		myUtils.returnElement("xpath", "//a[@href='load-allindiamarksAnalysis']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//Student wise error analysis
		myUtils.returnElement("xpath", "//a[@href='load-QuestionWiseErrorReport']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-subjectwiserightwrongreportform
		myUtils.returnElement("xpath", "//a[@href='load-subjectwiserightwrongreportform']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-campuswiseerrorreport
		myUtils.returnElement("xpath", "//a[@href='load-campuswiseerrorreport']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-Statewiseerrorreport
		myUtils.returnElement("xpath", "//a[@href='load-Statewiseerrorreport']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-subjectwisemarksranges
		myUtils.returnElement("xpath", "//a[@href='load-subjectwisemarksranges']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//SubjectWiseReport
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 500)");
		myUtils.returnElement("xpath", "//a[@href='SubjectWiseReport']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-fiftypercentmarkssubjectwise
		myUtils.returnElement("xpath", "//a[@href='load-fiftypercentmarkssubjectwise']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-presentprevmarksAnalysis
		myUtils.returnElement("xpath", "//a[@href='load-presentprevmarksAnalysis']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-below100rankssubjectwiseincampus
		myUtils.returnElement("xpath", "//a[@href='load-below100rankssubjectwiseincampus']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-sectionwiseattendiesAvgs
		myUtils.returnElement("xpath", "//a[@href='load-sectionwiseattendiesAvgs']//img[@id='rcorners2']").click();
		myUtils.returnElement("xpath", "//button[@onclick='history.back();']").click();
		//load-QuestionwiseTimeAnalysis
		myUtils.returnElement("xpath", "//a[@href='load-QuestionwiseTimeAnalysis']//img[@id='rcorners2']").click();
		js.executeScript("window.scrollBy(0, 500)");
		myUtils.returnElement("xpath", "//a[contains(text(),'BACK TO SELECT EXAM')]").click();
		myUtils.returnElement("xpath", "//a[contains(text(),'DASHBOARD')]").click();

	}
}
