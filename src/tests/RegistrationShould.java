package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PageIsOpen;
import objects.NavigationBar;
import objects.ReadPaths;
import objects.ReadUrls;
import objects.RegistrationPage;

public class RegistrationShould {
	WebDriver driver;
	Map<String, String> urls = new HashMap<>();
	Map<String, String> xPaths = new HashMap<>();

	@Test
	public void NotRegisterWithoutUsernameAndPassword() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\SandboxSiteTestingITBC\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openRegistration(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		RegistrationPage register = new RegistrationPage(driver, ReadPaths.readXPaths());
		register.clickSignUp();

		checkOut.assertNotEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox/home/dashboard");
		checkOut.assertFalse(driver.getCurrentUrl().contains(open.getUrlProfile()));

		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}

	@Test
	public void registerOneUser() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openRegistration(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		RegistrationPage register = new RegistrationPage(driver, ReadPaths.readXPaths());

		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);

		register.inputUsername(utils.ExcelUtils.getDataAt(1, 0));
		register.inputEmail(utils.ExcelUtils.getDataAt(1, 1));
		register.inputPassword(utils.ExcelUtils.getDataAt(1, 2));
		register.inputCofirmPassword(utils.ExcelUtils.getDataAt(1, 2));
		register.chooseHaveWebsite("www.website.com");

		register.clickSignUp();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox/home/dashboard");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlProfile()));

		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}

	@Test
	public void registerMultipleUsers() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openRegistration(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		RegistrationPage register = new RegistrationPage(driver, ReadPaths.readXPaths());

		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);

		for (int i = 1; i < utils.ExcelUtils.getRowNumber(); i++) {
			
			register.inputUsername(utils.ExcelUtils.getDataAt(i, 0));
			register.inputEmail(utils.ExcelUtils.getDataAt(i, 1));
			register.inputPassword(utils.ExcelUtils.getDataAt(i, 2));
			register.inputCofirmPassword(utils.ExcelUtils.getDataAt(i, 2));
			
			if (utils.ExcelUtils.getRowNumber() == 1) register.chooseDontHaveWebsite();
			else if (utils.ExcelUtils.getRowNumber() == 2) register.chooseSeveralWebsite();
			else if (utils.ExcelUtils.getRowNumber() == 3) register.chooseAlreadyHaveAccount();
			else register.chooseWantToPlay();

			register.clickSignUp();

			checkOut.assertEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox/home/dashboard");
			checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlProfile()));
			
			NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
			profile.AccountAvatar();
			profile.LogOut();
			
			if (i < utils.ExcelUtils.getRowNumber() - 1) open.openRegistration(driver);

		}
		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}
}
