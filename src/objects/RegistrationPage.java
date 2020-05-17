package objects;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

	WebDriver driver;
	Map<String, String> xPaths;
	
	private static final String USERNAME = "USERNAMESIGNUPPAGE";
	private static final String EMAIL = "EMAILSIGNUPPAGE";
	private static final String PASSWORD = "PASSWORDSIGNUPPAGE";
	private static final String CONFIRMPASSWORD = "CONFIRMPASSWORDSIGNUPPAGE";
	private static final String DBOXABOUTYOU = "DROPBOXABOUTYOUSIGNUPPAGE";
	private static final String DBOXHAVEWEBSITE = "DBOXHAVEWEBSITESIGNUPPAGE";	
	private static final String DBOXTXTWEBSITEURL = "DBOXTXTWEBSITEURLSIGNUPPAGE";	
	private static final String DBOXDONTHAVEWEBSITE = "DBOXDONTHAVEWEBSITESIGNUPPAGE";
	private static final String DBOXSEVERALWEBSITE = "DBOXSEVERALWEBSITESIGNUPPAGE";
	private static final String DBOXALREADYHAVEACCOUNT = "DBOXALREADYHAVEACCOUNTSIGNUPPAGE";
	private static final String DBOXWANTTOPLAY = "DBOXWANTTOPLAYSIGNUPPAGE";
	private static final String LOGIN = "LOGINSIGNUPPAGE";
	private static final String TERMSOFUSE = "TERMSOFUSESIGNUPPAGE";
	private static final String PRIVACYPOLICY = "PRIVACYPOLICYSIGNUPPAGE";
	private static final String SIGNUP = "SIGNUP";
	private static final String TERMSOFUSEFOOTER = "TERMSOFUSEFOOTERSIGNUPPAGE";
	private static final String PRIVAYPOLICYFOOTER = "PRIVACYPOLICYFOOTERSIGNUPPAGE";

	// constructor
	public RegistrationPage(WebDriver driver, Map<String, String> xPaths) {
		this.driver = driver;
		this.xPaths = xPaths;
	}
	
	public void inputUsername(String key) {
		driver.findElement(By.xpath(xPaths.get(USERNAME))).sendKeys(key);
	}
	public String getUsernamePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(USERNAME)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
		public void inputEmail(String key) {
		driver.findElement(By.xpath(xPaths.get(EMAIL))).sendKeys(key);
	}	
	public String getEmailPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(EMAIL)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void inputPassword(String key) {
		driver.findElement(By.xpath(xPaths.get(PASSWORD))).sendKeys(key);
	}	
	public String getPasswordPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(PASSWORD)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void inputCofirmPassword(String key) {
		driver.findElement(By.xpath(xPaths.get(CONFIRMPASSWORD))).sendKeys(key);
	}
	public String getCofirmPasswordPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(CONFIRMPASSWORD)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public String getAboutYou() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DBOXABOUTYOU)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	public void chooseHaveWebsite(String key) {
		driver.findElement(By.xpath(xPaths.get(DBOXABOUTYOU))).click();
		driver.findElement(By.xpath(xPaths.get(DBOXHAVEWEBSITE))).click();	
		driver.findElement(By.xpath(xPaths.get(DBOXTXTWEBSITEURL))).sendKeys(key);
	}
	public String getHaveWebsitePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DBOXHAVEWEBSITE)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	public String getTxtWebsitePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DBOXTXTWEBSITEURL)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

	public void chooseDontHaveWebsite() {
		driver.findElement(By.xpath(xPaths.get(DBOXABOUTYOU))).click();
		driver.findElement(By.xpath(xPaths.get(DBOXDONTHAVEWEBSITE))).click();		
	}
	public String getDontHaveWebsitePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DBOXDONTHAVEWEBSITE)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void chooseSeveralWebsite() {
		driver.findElement(By.xpath(xPaths.get(DBOXABOUTYOU))).click();
		driver.findElement(By.xpath(xPaths.get(DBOXSEVERALWEBSITE))).click();		
	}
	public String getSeveralWebsitePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DBOXSEVERALWEBSITE)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void chooseAlreadyHaveAccount() {
		driver.findElement(By.xpath(xPaths.get(DBOXABOUTYOU))).click();
		driver.findElement(By.xpath(xPaths.get(DBOXALREADYHAVEACCOUNT))).click();		
	}
	public String getAlreadyHaveAccountPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DBOXALREADYHAVEACCOUNT)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
	
	public void chooseWantToPlay() {
		driver.findElement(By.xpath(xPaths.get(DBOXABOUTYOU))).click();
		driver.findElement(By.xpath(xPaths.get(DBOXWANTTOPLAY))).click();		
	}
	public String getWantToPlayPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DBOXWANTTOPLAY)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

	public void LogIn() {
		driver.findElement(By.xpath(xPaths.get(LOGIN))).click();
	}
	public String getLogInPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(LOGIN)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

	public void TermsOfUse() {
		driver.findElement(By.xpath(xPaths.get(TERMSOFUSE))).click();
	}
	public String getTermsOfUsePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(TERMSOFUSE)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

	public void clickPrivacyPolicy() {
		driver.findElement(By.xpath(xPaths.get(PRIVACYPOLICY))).click();
	}
	public String getPrivacyPolicyPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(PRIVACYPOLICY)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

	public void clickSignUp() {
		driver.findElement(By.xpath(xPaths.get(SIGNUP))).click();
	}
	public String getSignUpPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(SIGNUP)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

	public void clickTermsOfUseFooter() {
		driver.findElement(By.xpath(xPaths.get(TERMSOFUSEFOOTER))).click();
	}
	public String getTermsOfUseFooterPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(TERMSOFUSEFOOTER)) xPath = xPaths.get(i);
		}		
		return xPath;
	}

	public void PrivacyPolicyFooter() {
		driver.findElement(By.xpath(xPaths.get(PRIVAYPOLICYFOOTER))).click();
	}	
	public String getPrivacyPolicyFooterPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(PRIVAYPOLICYFOOTER)) xPath = xPaths.get(i);
		}		
		return xPath;
	}
}
