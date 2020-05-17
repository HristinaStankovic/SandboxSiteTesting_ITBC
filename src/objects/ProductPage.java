package objects;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

	WebDriver driver;
	Map<String, String> xPaths;
	Map<String, String> urls;

	private final static String ADDNEWPRODUCT = "ADDNEWPRODUCT";
	private final static String CHECKBOXPRODUCT = "ONEPRODUCTCHECKBOXPRODUCT";
	private final static String DELETEPRODUCT = "DELETEPRODUCT";
	private final static String PRODUCTNAME = "PRODUCTINFORMATIONPRODUCTNAME";
	private final static String PRODUCTID = "PRODUCTINFORMATIONPRODUCTID";
	private final static String SHORTPRODUCTDESCRIPTION = "PRODUCTINFORMATIONSHORTPRODUCTDESCRIPTION";
	private final static String LONGPRODUCTDESCRIPTION = "PRODUCTINFORMATIONLONGPRODUCTDESCRIPTION";
	private final static String PRODUCTPRICE = "PRODUCTINFORMATIONPRODUCTPRICE";
	private final static String APPROVEDPRODUCTURL = "PRODUCTINFORMATIONAPPROVEDURL";
	private final static String SUBMIT = "CREATINGPRODUCTSUBMIT";
	private final static String EDITPRODUCT = "EDITPRODUCT";
	private final static String SAVEPRODUCTCHANGES = "SAVEPRODUCTCHANGES";
	private final static String UPDATESUCCEED = "ALLUPDATESUCCEEDEDEDITPRODUCTS";

	private final static String URLEDITPRICE = "PRODUCTEDITPRICEPROFILEPAGE";

	// constructor
	public ProductPage(WebDriver driver, Map<String, String> xPaths, Map<String, String> urls) {
		this.driver = driver;
		this.xPaths = xPaths;
	}

	public void AddNewProduct() {
		driver.findElement(By.xpath(xPaths.get(ADDNEWPRODUCT))).click();
	}

	public String getAddNewProductPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(ADDNEWPRODUCT))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	// method to click checkbox product when we have ONLY ONE product!
	public void CheckboxProduct() {
		driver.findElement(By.xpath(xPaths.get(CHECKBOXPRODUCT))).click();
	}

	public String getCheckboxProductPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(CHECKBOXPRODUCT))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	public void DeleteProduct() {
		driver.findElement(By.xpath(xPaths.get(DELETEPRODUCT))).click();
	}

	public String getDeleteProductPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(DELETEPRODUCT))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	public void inputProductName(String keys) {
		driver.findElement(By.xpath(xPaths.get(PRODUCTNAME))).sendKeys(keys);
	}

	public String getProductNamePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(PRODUCTNAME))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	public void inputProductId(String keys) {
		driver.findElement(By.xpath(xPaths.get(PRODUCTID))).sendKeys(keys);
	}

	public String getProductIdPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(PRODUCTID))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	public void inputShortDescription(String keys) {
		driver.findElement(By.xpath(xPaths.get(SHORTPRODUCTDESCRIPTION))).sendKeys(keys);
	}

	public String getShortDescriptionPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(SHORTPRODUCTDESCRIPTION))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	public void inputLongDescription(String keys) {
		driver.findElement(By.xpath(xPaths.get(LONGPRODUCTDESCRIPTION))).sendKeys(keys);
	}

	public String getLongDescriptionPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(LONGPRODUCTDESCRIPTION))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

		public void inputProductPrice(String keys) {
		driver.findElement(By.xpath(xPaths.get(PRODUCTPRICE))).sendKeys(keys);
	}

	public String getProductPricePath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(PRODUCTPRICE))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	public void inputApprovedUrl(String keys) {
		driver.findElement(By.xpath(xPaths.get(APPROVEDPRODUCTURL))).sendKeys(keys);
	}

	public String getApprovedUrlPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(APPROVEDPRODUCTURL))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	public void Submit() {
		driver.findElement(By.xpath(xPaths.get(SUBMIT))).click();
	}

	public String getSubmitPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(SUBMIT))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	// increasePrice
	public void priceChange(Integer priceChange) {
		List<WebElement> product = driver.findElements(By.xpath("//*[contains(@name, 'price')]"));
		Iterator<WebElement> itr = product.iterator();
		while (itr.hasNext()) {
			WebElement element = itr.next();
			String value = itr.next().getAttribute("value");
			int incValue = priceChange + Integer.parseInt(value);
			System.out.println(incValue);
			element.clear();
			element.sendKeys(String.valueOf(incValue));
		}
	}

	// edit price
	public void openEditPrice(WebDriver driver) {
		driver.get(urls.get(URLEDITPRICE));
	}

	public String getUrlEditPrice() {
		String url = "Error";
		for (String i : urls.keySet()) {
			if (i.equals(URLEDITPRICE))
				url = urls.get(i);
		}
		return url;
	}

	public void EditProduct() {
		driver.findElement(By.xpath(xPaths.get(EDITPRODUCT))).click();
	}

	public String getEditProductPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(EDITPRODUCT))
				xPath = xPaths.get(i);
		}
		return xPath;
	}
	
	public void increasePrice(Double increase) {
		
		List<WebElement> allElements = driver.findElements(By.cssSelector("input"));
		for (WebElement anElement : allElements) {
			if (anElement.getAttribute("type").equals("text")) {
				anElement.click();
				String oldPrice = anElement.getAttribute("value");
				double incPrice = increase + Double.parseDouble(oldPrice);
				System.out.println(incPrice);
				anElement.clear();
				anElement.sendKeys(String.valueOf(incPrice));
			}
		}
	}
	
	// save product changes  
	public void SaveProductChanges() {
		driver.findElement(By.xpath(xPaths.get(SAVEPRODUCTCHANGES))).click();
	}

	public String getSaveProductChangesPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(SAVEPRODUCTCHANGES))
				xPath = xPaths.get(i);
		}
		return xPath;
	}
	
	// product price edited check 
	public String getUpdateSucceedPath() {
		String xPath = "Error";
		for (String i : xPaths.keySet()) {
			if (i.equals(UPDATESUCCEED))
				xPath = xPaths.get(i);
		}
		return xPath;
	}

	// xPath of checkbox is not the same when we have more then one product
	// checkbox - select al boxes - so we can delete more then one product
	public void checkAllProducts() {
		List<WebElement> allElements = driver.findElements(By.cssSelector("input"));
		for (WebElement anElement : allElements) {
			if (anElement.getAttribute("type").equals("checkbox")) {
				anElement.click();
			}
		}
	}
}
