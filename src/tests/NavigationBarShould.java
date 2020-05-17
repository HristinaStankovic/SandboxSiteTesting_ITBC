package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.LoginPage;
import objects.PageIsOpen;
import objects.NavigationBar;
import objects.ReadPaths;
import objects.ReadUrls;

public class NavigationBarShould {
	WebDriver driver;
	Map<String, String> urls = new HashMap<>();
	Map<String, String> xPaths = new HashMap<>();

	@Test
	public void haveNavBarItems() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getHomeNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getAccountNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getSalesNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getProductsNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getShippingNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getReportsNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getApiNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getNotificationsNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getHelpNavPath())).isEnabled());
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getAccountAvatarPath())).isEnabled());

		profile.getAccountAvatarPath();
		checkOut.assertTrue(driver.findElement(By.xpath(profile.getLogOutPath())).isEnabled());

		checkOut.assertAll();
		driver.close();
	}

	@Test
	public void leadToHome() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.HomeNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}

	@Test
	public void leadToAccount() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.AccountNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlAccountNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
	
	@Test
	public void leadToSales() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\SandboxSiteTestingITBC\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.SalesNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlSalesNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
	
	@Test
	public void leadToProduct() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.ProductsNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProductsNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
	
	@Test
	public void leadToShipping() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.ShippingNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlShippingNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
	
	@Test
	public void leadToReports() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.ReportsNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlReportsNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
	
	@Test
	public void leadToApi() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.ApiNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlApiNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
	
	@Test
	public void leadToNotification() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.NotificationsNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlNotificationsNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
	
	@Test
	public void leadToHelp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();

		SoftAssert checkOut = new SoftAssert();

		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlProfile());

		NavigationBar profile = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		profile.HelpNav();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlHelpNavBar());

		profile.AccountAvatar();
		profile.LogOut();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlLogin());

		checkOut.assertAll();
		driver.close();
	}
}
