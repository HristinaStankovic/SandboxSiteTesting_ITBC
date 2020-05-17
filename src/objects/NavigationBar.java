package objects;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
	
	WebDriver driver;
	Map<String, String> xPaths;
	Map<String, String> urls;
	
	private static final String HOME = "NAVBARHOMEPROFILEPAGE";
	private static final String ACCOUNT = "NAVBARACCOUNTPROFILEPAGE";
	private static final String SALES = "NAVBARSALESPROFILEPAGE";
	private static final String PRODUCTS = "NAVBARPRODUCTSPROFILEPAGE";
	private static final String CREATENEWPRODUCT = "CREATENEWPRODUCTPROFILEPAGE";
	private static final String UPDATEPRODUCT = "UPDATEPRODUCTSUCCESSFUL";
	private static final String SHIPPING = "NAVBARSHIPPINGPROFILEPAGE";
	private static final String REPORTS = "NAVBARREPORTSPROFILEPAGE";
	private static final String API = "NAVBARAPIPROFILEPAGE";
	private static final String NOTIFICATIONS = "NAVBARNOTIFICATIONSPROFILEPAGE";
	private static final String HELP = "NAVBARHELPPROFILEPAGE";
	private static final String ACCOUNTAVATAR = "NAVBARACCOUNTAVATARPROFILEPAGE";
	private static final String LOGOUT = "NAVBARLOGOUTPROFILEPAGE";
	
	public NavigationBar(WebDriver driver, Map<String, String> xPaths, Map<String, String> urls) {
		this.driver = driver;
		this.xPaths = xPaths;
		this.urls = urls;
	}
	
	public void HomeNav() {
		driver.findElement(By.xpath(xPaths.get(HOME))).click();
	}
	public String getHomeNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(HOME)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void AccountNav() {
		driver.findElement(By.xpath(xPaths.get(ACCOUNT))).click();
	}
	public String getAccountNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(ACCOUNT)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void SalesNav() {
		driver.findElement(By.xpath(xPaths.get(SALES))).click();
	}
	public String getSalesNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(SALES)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void ProductsNav() {
		driver.findElement(By.xpath(xPaths.get(PRODUCTS))).click();
	}
	public String getUpdateSuccessfulPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(UPDATEPRODUCT)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	public String getCreateNewProductUrl() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(CREATENEWPRODUCT)) url = urls.get(i);
		}		
		return url;
	}
	public String getProductsNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(PRODUCTS)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void ShippingNav() {
		driver.findElement(By.xpath(xPaths.get(SHIPPING))).click();
	}
	public String getShippingNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(SHIPPING)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void ReportsNav() {
		driver.findElement(By.xpath(xPaths.get(REPORTS))).click();
	}
	public String getReportsNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(REPORTS)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void ApiNav() {
		driver.findElement(By.xpath(xPaths.get(API))).click();
	}
	public String getApiNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(API)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void NotificationsNav() {
		driver.findElement(By.xpath(xPaths.get(NOTIFICATIONS))).click();
	}
	public String getNotificationsNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(NOTIFICATIONS)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void HelpNav() {
		driver.findElement(By.xpath(xPaths.get(HELP))).click();
	}
	public String getHelpNavPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(HELP)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void AccountAvatar() {
		driver.findElement(By.xpath(xPaths.get(ACCOUNTAVATAR))).click();
	}
	public String getAccountAvatarPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(ACCOUNTAVATAR)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void LogOut() {
		driver.findElement(By.xpath(xPaths.get(LOGOUT))).click();
	}
	public String getLogOutPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(LOGOUT)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

}
