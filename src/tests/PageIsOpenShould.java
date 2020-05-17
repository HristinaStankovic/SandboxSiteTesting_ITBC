 package tests;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.PageIsOpen;
import objects.ReadUrls;



public class PageIsOpenShould {
	Map<String, String> urls;
	WebDriver driver;

	@Test
	public void openLoginPage() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\SandboxSiteTestingITBC\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlLogin()));

		checkOut.assertAll();
		driver.quit();
	}

	@Test
	public void openRecoveryProfile() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openRecoveryProfile(driver);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://sandbox.2checkout.com/sandbox/noauth/forgotten_password");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlForgotPassword()));

		driver.quit();
	}
	
	@Test
	public void openRegistration() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openRegistration(driver);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://www.2checkout.com/pricing/");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlRegistration()));

		driver.quit();
	}
	
	@Test
	public void openCheckOut() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openCheckOut(driver);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://secure.2checkout.com/cpanel/login.php");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlCheckOut()));

		driver.quit();
	}
	
	@Test
	public void openTermsOfUse() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openTermsOfUse(driver);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://www.2checkout.com/legal/terms/?_ga=2.68427986.274721211.1588585801-1643580948.1588585801");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlTermsOfUse()));

		driver.quit();
	}
	
	@Test
	public void openPrivacyPolicy() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openPrivacyPolicy(driver);

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), "https://www.2checkout.com/legal/privacy/?_ga=2.68427986.274721211.1588585801-1643580948.1588585801");
		checkOut.assertTrue(driver.getCurrentUrl().contains(open.getUrlPrivacyPolicy()));

		driver.quit();
	}
}
