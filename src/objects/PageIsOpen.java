package objects;

import java.util.Map;

import org.openqa.selenium.WebDriver;

public class PageIsOpen {

	WebDriver driver;
	Map<String, String> urls;
	
	private static final String SANDBOXLOGINPAGE = "SANDBOXLOGINPAGE";		
	private static final String FORGOTPASSWORD = "FORGOTPASSWORDPAGE";
	private static final String URLREGISTRATIONPAGE = "SIGNUPPAGE";
	private static final String URLCHECKOUT = "CHECKOUTPAGE";
	private static final String URLTERMSOFUSE = "TERMSOFUSEPAGE";
	private static final String URLPRIVACYPOLICY = "PRIVACYPOLICYPAGE";
	private static final String PROFILEHOMEPAGE = "PROFILEHOMEPAGE";

	private static final String URLACCOUNT = "ACCOUNTNAVBARPROFILEPAGE";
	private static final String URLSALES = "SALESNAVBARPROFILEPAGE";
	private static final String URLPRODUCTS = "PRODUCTSNAVBARPROFILEPAGE";
	private static final String URLSHIPPING = "SHIPPINGNAVBARPROFILEPAGE";
	private static final String URLREPORTS = "REPORTSNAVBARPROFILEPAGE";
	private static final String URLAPI = "APINAVBARPROFILEPAGE";
	private static final String URLNOTIFICATIONS = "NOTIFICATIONSNAVBARPROFILEPAGE";
	private static final String URLHELP = "HELPNAVBARPROFILEPAGE";
	private static final String URLDELETEDPRODUCT = "DELETEDPRODUCTPROFILEPAGE";

	
	public PageIsOpen(WebDriver driver, Map<String, String> urls) {
		this.driver = driver;
		this.urls = urls;
	}
	
	public void openLogin(WebDriver driver) {
		driver.get(urls.get(SANDBOXLOGINPAGE));
	}
	
	public String getUrlLogin() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(SANDBOXLOGINPAGE)) url = urls.get(i);
		}		
		return url;
	}
	
	public void openRecoveryProfile(WebDriver driver) {
		driver.get(urls.get(FORGOTPASSWORD));
	}
	
	public String getUrlForgotPassword() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(FORGOTPASSWORD)) url = urls.get(i);
		}		
		return url;
	}
	
	public void openRegistration(WebDriver driver) {
		driver.get(urls.get(URLREGISTRATIONPAGE));
	}
	
	public String getUrlRegistration() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLREGISTRATIONPAGE)) url = urls.get(i);
		}		
		return url;
	}
	
	public void openCheckOut(WebDriver driver) {
		driver.get(urls.get(URLCHECKOUT));
	}
	
	public String getUrlCheckOut() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLCHECKOUT)) url = urls.get(i);
		}		
		return url;
	}
	
	public void openTermsOfUse(WebDriver driver) {
		driver.get(urls.get(URLTERMSOFUSE));
	}
	
	public String getUrlTermsOfUse() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLTERMSOFUSE)) url = urls.get(i);
		}		
		return url;
	}
	
	public void openPrivacyPolicy(WebDriver driver) {
		driver.get(urls.get(URLPRIVACYPOLICY));
	}
	
	public String getUrlPrivacyPolicy() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLPRIVACYPOLICY)) url = urls.get(i);
		}		
		return url;
	}
	
	public String getUrlProfile() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(PROFILEHOMEPAGE)) url = urls.get(i);
		}		
		return url;
	}
	
	public String getUrlAccountNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLACCOUNT)) url = urls.get(i);
		}		
		return url;
	}
	
	public String getUrlSalesNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLSALES)) url = urls.get(i);
		}		
		return url;
	}

	public String getUrlProductsNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLPRODUCTS)) url = urls.get(i);
		}		
		return url;
	}
	
	public String getUrlShippingNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLSHIPPING)) url = urls.get(i);
		}		
		return url;
	}

	public String getUrlReportsNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLREPORTS)) url = urls.get(i);
		}		
		return url;
	}

	public String getUrlApiNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLAPI)) url = urls.get(i);
		}		
		return url;
	}

	public String getUrlNotificationsNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLNOTIFICATIONS)) url = urls.get(i);
		}		
		return url;
	}

	public String getUrlHelpNavBar() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLHELP)) url = urls.get(i);
		}		
		return url;
	}
	
	public String getUrlDeletedProduct() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLDELETEDPRODUCT)) url = urls.get(i);
		}		
		return url;
	}
}
