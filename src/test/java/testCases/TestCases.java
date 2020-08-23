package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import generalUtilities.ReadProperties;
import generalUtilities.ReadXl;
import generalUtilities.Snipper;
import pageObjects.AddLecturer;
import pageObjects.AddLocation;
import pageObjects.AddState;
import pageObjects.AddStudent;
import pageObjects.Addcontactdetails;
import pageObjects.CreateExam;
import pageObjects.DeleteLecturer;
import pageObjects.DeleteLocation;
import pageObjects.DeleteState;
import pageObjects.DeleteStudent;
import pageObjects.FilterExamCriteria;
import pageObjects.Login;
import pageObjects.ModifyLecturer;
import pageObjects.ModifyLocation;
import pageObjects.ModifyState;
import pageObjects.ModifyStudent;
import pageObjects.QuestionType;
import pageObjects.Reports;
import pageObjects.Resultscalculation;
import pageObjects.SetExamPattern;
import pageObjects.UploadClientCarousel;
import pageObjects.UploadLogo;
import testSuites.TestSuites;

public class TestCases {
	WebDriver driver;
	Login myLogin;
	AddLecturer addlect;
	ModifyLecturer mlect;
	DeleteLecturer dlect;
	Addcontactdetails addcd;
	Resultscalculation rcl;
	AddStudent addst;
	ModifyStudent mst;
	DeleteStudent dst;
	CreateExam cexam;
	ReadXl myXl;
	public static String env;
	public static String sname;
	ReadProperties myProp;
	boolean result;
	String screenshotfilepath;
	Snipper snip;
	SetExamPattern sep;
	UploadLogo ul;
	UploadClientCarousel ucl;
	QuestionType qt;
	AddState ast;
	ModifyState mstate;
	DeleteState dstate;
	AddLocation aloc;
	ModifyLocation mloc;
	DeleteLocation dloc;
	FilterExamCriteria fexmc;
	Reports rpt;

	public TestCases() {
		myProp = new ReadProperties(TestSuites.configFilePath);
		env = myProp.readValue("environment");
		sname = myProp.readValue("Filesheetname");
		myXl = new ReadXl(TestSuites.xlFilePath);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\browser\\Chrome-2.40\\chromedriver.exe");
		driver = new ChromeDriver(options);
		myLogin = new Login(driver);
		addlect = new AddLecturer(driver);
		snip = new Snipper(driver);
		mlect = new ModifyLecturer(driver);
		dlect = new DeleteLecturer(driver);
		addcd = new Addcontactdetails(driver);
		rcl = new Resultscalculation(driver);
		addst = new AddStudent(driver);
		mst = new ModifyStudent(driver);
		dst = new DeleteStudent(driver);
		cexam = new CreateExam(driver);
		sep = new SetExamPattern(driver);
		ul = new UploadLogo(driver);
		ucl = new UploadClientCarousel(driver);
		qt = new QuestionType(driver);
		ast = new AddState(driver);
		mstate = new ModifyState(driver);
		dstate = new DeleteState(driver);
		aloc = new AddLocation(driver);
		mloc = new ModifyLocation(driver);
		dloc = new DeleteLocation(driver);
		fexmc = new FilterExamCriteria(driver);
		rpt = new Reports(driver);
	}

	public boolean electusTest() {
		//result = true;
		try {

			for (int i = 1; i < myXl.getRowCount(env); i++) {
				myLogin.launchApplication();
				myLogin.loginToApplication_DataDriven();
//				ast.addState();
//				mstate.modifyState();
//				dstate.deleteState();
//				aloc.addLocation();
//				mloc.modifyLocation();
//				dloc.deleteLocation();
//				addst.addStudent();
//				mst.modifyStudent();
//				dst.deleteStudent();
//				cexam.examCreate();
//				addlect.addLecturer();
//				mlect.modifyLecturer();
//				dlect.deleteLecturer();
//				addcd.addContactDetails();
//				rcl.resultsCalculations();
//				sep.setExamPttern();
//				ul.uploadLogo();
//				ucl.uploadClientCarousel();
//				qt.questionType();
//				fexmc.filterExamCriteria();
				rpt.reports();

			}
			result = true;
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	public String takeScreenShot(String name) {
		return snip.takeErrorScreenShot(name);
	}

}
