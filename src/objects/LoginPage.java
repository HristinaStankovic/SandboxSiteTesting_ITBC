package objects;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	WebDriver driver;
	Map<String, String> xPaths;
	
	private static final String USERNAME = "USERNAMELOGINPAGE";
	private static final String PASSWORD = "PASSWORDLOGINPAGE";
	private static final String FORGOTPASSWORD = "FORGOTPASSWORDLOGINPAGE";
	private static final String LOGIN = "LOGIN";
	private static final String SIGNUP = "SIGNUPLOGINPAGE";
	private static final String TERMSOFUSE = "TERMSOFUSEFOOTERLOGINPAGE";
	private static final String PRIVACYPOLICY = "PRIVACYPOLICYFOOTERLOGINPAGE";

	// constructor
	public LoginPage(WebDriver driver, Map<String, String> xPaths) {
		this.driver = driver;
		this.xPaths = xPaths;
	}

		public void inputUsername(String key) {
		driver.findElement(By.xpath(xPaths.get(USERNAME))).sendKeys(key);
	}
	public String getXPathUsername() {
		String xpath = xPaths.get(USERNAME);
		return xpath;
	}

	public void inputPassword(String key) {
		driver.findElement(By.xpath(xPaths.get(PASSWORD))).sendKeys(key);
	}

	public void forgotPassword() {
		driver.findElement(By.xpath(xPaths.get(FORGOTPASSWORD))).click();
	}

	public void LoginButton() {
		driver.findElement(By.xpath(xPaths.get(LOGIN))).click();
	}

	public void SignUp() {
		driver.findElement(By.xpath(xPaths.get(SIGNUP))).click();
	}

	public void TermsOfUse() {
		driver.findElement(By.xpath(xPaths.get(TERMSOFUSE))).click();
	}

	public void PrivacyPolicy() {
		driver.findElement(By.xpath(xPaths.get(PRIVACYPOLICY))).click();
	}

}
