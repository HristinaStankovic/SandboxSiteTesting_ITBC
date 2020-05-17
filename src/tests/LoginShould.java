package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PageIsOpen;
import objects.LoginPage;
import objects.NavigationBar;
import objects.ReadPaths;
import objects.ReadUrls;

public class LoginShould {
	WebDriver driver;
	Map<String, String> urls = new HashMap<>();
	Map<String, String> xPaths = new HashMap<>();

	@Test
	public void NotLogWithoutUsernameAndPassword() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\SandboxSiteTestingITBC\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());

		login.LoginButton();

		checkOut.assertNotEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox/home/dashboard");
		checkOut.assertFalse(driver.getCurrentUrl().contains(open.getUrlProfile()));

		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}

	@Test
	public void logOneUser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());

		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);

		login.inputUsername(utils.ExcelUtils.getDataAt(1, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(1, 2));

		login.LoginButton();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox/home/dashboard");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlProfile()));

		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}

	@Test
	public void logMultipleUsers() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());

		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);

		for (int i = 1; i < utils.ExcelUtils.getRowNumber(); i++) {

			login.inputUsername(utils.ExcelUtils.getDataAt(i, 0));
			login.inputPassword(utils.ExcelUtils.getDataAt(i, 2));

			login.LoginButton();

			checkOut.assertEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox/home/dashboard");
			checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlProfile()));
			
			NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
			profile.AccountAvatar();
			profile.LogOut();

		}
		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}
}
