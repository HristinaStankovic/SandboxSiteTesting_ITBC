package tests;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.LoginPage;
import objects.PageIsOpen;
import objects.ProductPage;
import objects.NavigationBar;
import objects.ReadPaths;
import objects.ReadUrls;

public class ProductPageShould {
	WebDriver driver;
	Map<String, String> urls = new HashMap<>();
	Map<String, String> xPaths = new HashMap<>();

	@Test (priority = 1) @Ignore
	public void createNewProduct() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\Projekti Java\\SandboxSiteTestingITBC\\src\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();
		
		SoftAssert checkOut = new SoftAssert();

		NavigationBar navBar = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		navBar.ProductsNav();

		ProductPage product = new ProductPage(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		product.AddNewProduct();
		
		checkOut.assertEquals(driver.getCurrentUrl(), navBar.getCreateNewProductUrl());

		utils.ExcelUtils.setExcell("src\\ProductInformation_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		product.inputProductName(utils.ExcelUtils.getDataAt(1, 0));
		product.inputProductId(utils.ExcelUtils.getDataAt(1, 1));
		product.inputShortDescription(utils.ExcelUtils.getDataAt(1, 2));
		product.inputLongDescription(utils.ExcelUtils.getDataAt(1, 3));
		product.inputProductPrice(utils.ExcelUtils.getDataAt(1, 4));
		product.inputApprovedUrl(utils.ExcelUtils.getDataAt(1, 5));
		product.Submit();

		checkOut.assertTrue(driver.findElement(By.xpath(navBar.getUpdateSuccessfulPath())).isDisplayed());

		Thread.sleep(5000);

		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}

	@Test (priority = 2) @Ignore
	public void deleteProduct() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();
		
		SoftAssert checkOut = new SoftAssert();

		NavigationBar navBar = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		navBar.ProductsNav();

		ProductPage product = new ProductPage(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		checkOut.assertTrue(driver.findElement(By.xpath(product.getCheckboxProductPath())).isDisplayed());
		product.CheckboxProduct();
		checkOut.assertTrue(driver.findElement(By.xpath(product.getDeleteProductPath())).isDisplayed());
		product.DeleteProduct();
		checkOut.assertTrue(driver.findElement(By.xpath(product.getSubmitPath())).isDisplayed());
		product.Submit();
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlDeletedProduct());
		checkOut.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Deleted')]")).isDisplayed());
		
		Thread.sleep(5000);

		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}
 
	@Test (priority = 1) @Ignore
	public void createMultipleNewProduct() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();
		
		SoftAssert checkOut = new SoftAssert();
		
		NavigationBar navBar = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		navBar.ProductsNav();

		ProductPage product = new ProductPage(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		product.AddNewProduct();	

		checkOut.assertEquals(driver.getCurrentUrl(), navBar.getCreateNewProductUrl());

		utils.ExcelUtils.setExcell("src\\ProductInformation_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		for (int i = 2; i < utils.ExcelUtils.getRowNumber(); i++) {
			product.inputProductName(utils.ExcelUtils.getDataAt(i, 0));
			product.inputProductId(utils.ExcelUtils.getDataAt(i, 1));
			product.inputShortDescription(utils.ExcelUtils.getDataAt(i, 2));
			product.inputLongDescription(utils.ExcelUtils.getDataAt(i, 3));
			product.inputProductPrice(utils.ExcelUtils.getDataAt(i, 4));
			product.inputApprovedUrl(utils.ExcelUtils.getDataAt(i, 5));
			product.Submit();

			checkOut.assertTrue(driver.findElement(By.xpath(navBar.getUpdateSuccessfulPath())).isDisplayed());
			Thread.sleep(5000);
			if (i < utils.ExcelUtils.getRowNumber() - 1) {
				navBar.ProductsNav();
				product.AddNewProduct();
			}
		}
		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}
	
	@Test @Ignore
	public void deleteAllProducts() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();
		
		SoftAssert checkOut = new SoftAssert();
		
		NavigationBar navBar = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		navBar.ProductsNav();

		ProductPage product = new ProductPage(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		product.checkAllProducts();
		Thread.sleep(5000);
		product.DeleteProduct();
		product.Submit();
		
		checkOut.assertEquals(driver.getCurrentUrl(), open.getUrlDeletedProduct());
		checkOut.assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Deleted')]")).isDisplayed());
		
		Thread.sleep(5000);
		
		checkOut.assertAll();
		utils.ExcelUtils.closeExcell();
		driver.quit();
	}
	
	@Test (priority = 2)
	public void increasePrice() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageIsOpen open = new PageIsOpen(driver, ReadUrls.readUrls());
		open.openLogin(driver);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		LoginPage login = new LoginPage(driver, ReadPaths.readXPaths());
		utils.ExcelUtils.setExcell("src\\SignUp_data.xlsx");
		utils.ExcelUtils.setWorkSheet(0);
		login.inputUsername(utils.ExcelUtils.getDataAt(2, 0));
		login.inputPassword(utils.ExcelUtils.getDataAt(2, 2));
		login.LoginButton();
		NavigationBar navBar = new NavigationBar(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		ProductPage product = new ProductPage(driver, ReadPaths.readXPaths(), ReadUrls.readUrls());
		navBar.ProductsNav();
		product.EditProduct();		
		product.increasePrice(10.00);	
		Thread.sleep(5000);
		
		SoftAssert checkOut = new SoftAssert();
		
		checkOut.assertTrue(driver.findElement(By.xpath(product.getSaveProductChangesPath())).isDisplayed());
		product.SaveProductChanges();
		checkOut.assertTrue(driver.findElement(By.xpath(product.getUpdateSucceedPath())).isDisplayed());
		
		Thread.sleep(5000);
		
		checkOut.assertAll();
		driver.quit();
	}
}
