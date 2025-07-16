package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.SeleniumAction;
import utils.ExcelDataReader;
import utils.ExcelReader;

public class ConfigurationDemo extends SeleniumAction {
	
	protected WebDriver driver;

	// Constructor to initialize elements using the provided WebDriver
	public ConfigurationDemo(WebDriver driver) {
		super(driver); // Call the parent class constructor
		this.driver = driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}
	
	@FindBy(xpath = "//div[contains(@class, 'sadeNav-menu-item-text')]//label[contains(text(), 'Configuration')]")
	WebElement CongigurationModule;
	//mat-icon[contains(@class, 'Refresh')]/ancestor::button
	@FindBy(xpath = "//mat-icon[contains(@class, 'Refresh')]/ancestor::button")
	WebElement CongigurationRefreshBtn;
	@FindBy(xpath = "//mat-icon[contains(@class, 'plus_small')]/ancestor::button")
	WebElement CongigurationRPlusBtn;
	

	@FindBy(xpath = "//button[.//span[contains(text(), 'Cancel')]]")
	WebElement CongigurationCancelBtn;

//	xpaths for Nodepools
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableNodepoolPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconNodepool;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIcon;
	
	@FindBy(xpath="//div[contains(@class, 'mat-mdc-form-field-icon-suffix')]//mat-icon[contains(@class, 'close')]")
	WebElement closeSearchIcon;
	
	@FindBy(xpath="//button[.//mat-icon[contains(@data-mat-icon-name, 'filter_outline')]]")
	WebElement clickFilterIconNodepool;

	@FindBy(xpath = "//mat-select[.//span[contains(text(), 'Select')]]")
	private WebElement selectFilterButton;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickName;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterName;

	@FindBy(xpath = "//button[.//span[text()='Apply']]")
	private WebElement FilterApplyButton;
	
	@FindBy(xpath = "//span[contains(@class, 'custom-chips__icon') and contains(@class, 'close')]")
	private WebElement FilterCloseButton;
	
	
	@FindBy(xpath="//div[contains(text(), 'Configuration')]")
	private WebElement ValidateConfigurationModuleName;
	
	@FindBy(xpath="//div[text()=' gputesitnnfds ']")
	WebElement ValidateNodepoolSearchData;
	
//	@FindBy(xpath="//div[contains(@class, 'mat-mdc-form-field-icon-suffix')]//mat-icon[contains(@class, 'close')]")
//	WebElement ValidateNodepoolCloseSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateNodepoolFilterData;
	
public void ClickCongiguration() {
		
		waitForElementToBeVisible(CongigurationModule);
		CongigurationModule.click();
	}
public void ClickRefreshBtn() {
	
	waitForElementToBeVisible(CongigurationRefreshBtn);
	CongigurationRefreshBtn.click();
}
public void ClickCongigurationRPlusBtn() {
	
	waitForElementToBeVisible(CongigurationRPlusBtn);
	CongigurationRPlusBtn.click();
}


public void ClickCongigurationCongigurationCancelBtn() {
	
	waitForElementToBeVisible(CongigurationCancelBtn);
	CongigurationCancelBtn.click();
}

	
	//	Method for Nodepools
	
	
	
	
	public void matchNodepoolPageColumns() {
		String excelFilePath = "./src/main/resources/ExcelFile/Configuration_NodePoolGrid (1).xlsx";
		int colNum = 0;

		// Getting data from Excel file and saving in expectedList
		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}

		// Getting data from UI and saving in actualList
		List<String> actualList = new ArrayList<>();
		for (WebElement component : tableNodepoolPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
	       Assert.assertEquals(actualList, expectedList, "❌ Nodepool columns do not match.");
	}
	
	public void searchIconNodepool() throws InterruptedException, IOException {

//		searchIconNodepool.sendKeys("gpu");
		String excelFilePath = "./src/main/resources/ExcelFile/configuration_search.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 0); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);
		
		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconNodepool);
		searchIconNodepool.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconNodepool.sendKeys(Keys.ENTER);
		String Text = searchIconNodepool.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Nodepools is " + Text);
		closeSearchIcon.click();
		
	}
	
   public void clickFilterIconNodepool() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconNodepool);
		clickFilterIconNodepool.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButton.click();
		Thread.sleep(2000);
		filterclickName.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterName.sendKeys("gputesitnnfds");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButton.click();
		Thread.sleep(2000);	
		FilterCloseButton.click();
		Thread.sleep(2000);	
		
	}

//	xpaths for Associated Buckets
   
   @FindBy(xpath= "//span[text()='Associated buckets']")
	WebElement AssociatedBuckets;
	
   @FindBy(xpath= "//button[.//mat-icon[contains(@class, 'Refresh')]]")
   WebElement Associate_RefreshBtn;
 
   @FindBy(xpath= " //button[@aria-label='toolbutton' and .//mat-icon[@data-mat-icon-name='plus_small']]")
   WebElement Associate_PlusBtn;

   @FindBy(xpath= " //button[@aria-label='toolbutton' and .//span[text()='Cancel']]")
   WebElement Associate_CancelPlusBtn;
 
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableAssociatedBucketPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconAssocaitedBucketPage;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIconAssociatedBucket;
	
	@FindBy(xpath="//gridster-item//bntv-gx-ag-grid-header/div[1]/div[1]//bntv-search-box//bntv-mat-button[1]//button/span[3]")
	WebElement closeSearchIconAssociatedBucket;
	
	@FindBy(xpath="//*[@id=\"core-gx-ag-grid-header-filter-button_cmp_cmp-home_home\"]/div/button/span[3]")
	WebElement clickFilterIconAssociatedBucket;

	@FindBy(xpath = "//span[text()='Select filter']")
	private WebElement selectFilterButtonAssociatedBucket;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickNameAssociatedBucket;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterNameAssociatedBucket;

	@FindBy(xpath = "//div[contains(@id, 'mat-menu-panel-')]/div/filter/div/div[3]/bntv-mat-button/div/button/span[4]")
	private WebElement FilterApplyButtonAssociatedBucket;
	
	@FindBy(xpath="//span[contains(text(), 'vco01-nmj')]")
	WebElement ValidateAssociatedBucketSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateAssociatedBucketFilterData;
	
//	Method for Associated Buckets
	
	
public void ClickAssociatedBuckets() {
		
		waitForElementToBeVisible(AssociatedBuckets);
		AssociatedBuckets.click();
	}

public void ClickAssociate_RefreshBtn() {
	
	waitForElementToBeVisible(Associate_RefreshBtn);
	Associate_RefreshBtn.click();
}

public void ClickAssociate_PlusBtn() throws InterruptedException {
	
	waitForElementToBeVisible(Associate_PlusBtn);
	Associate_PlusBtn.click();

Thread.sleep(3000);
	Associate_CancelPlusBtn.click();
}



	
	public void matchABPageColumns() {
		String excelFilePath = "./src/main/resources/ExcelFile/Configuration_AssociatedBucketGrid.xlsx";
		int colNum = 0;

		// Getting data from Excel file and saving in expectedList
		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}

		// Getting data from UI and saving in actualList
		List<String> actualList = new ArrayList<>();
		for (WebElement component : tableAssociatedBucketPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		 Assert.assertEquals(actualList, expectedList, "❌ Associated Buckets columns do not match.");
	}
	
//	public void searchIconAssocaitedBucketPage() throws InterruptedException, IOException {
//
////		searchIconAssocaitedBucketPage.sendKeys("vco01");
//		String excelFilePath = "./src/main/resources/ExcelFile/configuration_search.xlsx";
//		 
//		System.out.println("file : " + excelFilePath);
// 
//		// Fetch only the first row from column 1 (0-based index)
//		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 0); // Sheet 0, Column 0, Row 1
// 
//		System.out.println("value : " + searchValue);
//		
//		Thread.sleep(3000);
//		waitForElementToBeClickable(searchIconAssocaitedBucketPage);
//		searchIconAssocaitedBucketPage.sendKeys(searchValue);
//		Thread.sleep(3000);
//		searchIconAssocaitedBucketPage.sendKeys(Keys.ENTER);
//		String Text = searchIconAssocaitedBucketPage.getText();
//		Thread.sleep(3000);
//		System.out.println("The name of the searched Associated Bucket is " + Text);
//		closeSearchIconAssociatedBucket.click();
//		
//	}
//	
//    public void clickFilterIconAssociatedBucket() throws InterruptedException {
//		
//		waitForElementToBeClickable(clickFilterIconAssociatedBucket);
//		clickFilterIconAssociatedBucket.click();
//		Thread.sleep(3000);
//		System.out.println("clicked on filter icon");
//		selectFilterButtonAssociatedBucket.click();
//		Thread.sleep(2000);
//		filterclickNameAssociatedBucket.click();
//		System.out.println("selected name in filter");
//		Thread.sleep(2000);
//		FilterEnterNameAssociatedBucket.sendKeys("vco01-nmj");
//		System.out.println("entered text in filter");
//		Thread.sleep(2000);
//		FilterApplyButtonAssociatedBucket.click();
//		Thread.sleep(2000);	
//		
//	}
//	
//	xpaths for Secrets
	
	@FindBy(xpath= "//div[@role='tab' and .//span[text()='Secrets']]")
	WebElement SecretsModule;
	
	@FindBy(xpath= "//button[.//mat-icon[@fonticon='Refresh']]")
	WebElement SecretsRefresh;

	@FindBy(xpath= "(//button[@role='button' and .//mat-icon[@fonticon='plus_small']])[1]")
	WebElement SecretPlusBtn;
	
	@FindBy(xpath= "//button[@role='button' and .//span[text()='Cancel']]")
	WebElement SecretCancelBtn;
	//button[@role='button' and .//span[text()='Cancel']]
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tableSecretsPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']") 
	WebElement searchIconsecrets;
	
	@FindBy(xpath="//input[contains(@class, 'mat-mdc-input-element') and @placeholder='Search by name']")
	WebElement clickSearchIconSecrets;
	
	@FindBy(xpath="//div[contains(@class, 'mat-mdc-form-field-icon-suffix')]//mat-icon[@fonticon='close']")
	WebElement closeSearchIconSecrets;
	
	@FindBy(xpath="//bntv-mat-button[contains(@id,'core-gx-ag-grid-filter-text')]//button[.//mat-icon[@data-mat-icon-name='filter_outline']]")
	WebElement clickFilterIconSecrets;

	@FindBy(xpath = "//mat-select[.//span[text()='Select']]") 
	private WebElement selectFilterButtonSecrets;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickNameSecrets;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterNameSecrets;

	@FindBy(xpath = "//button[.//span[text()='Apply']]")
	private WebElement FilterApplyButtonSecrets;
	
	
	@FindBy(xpath = "//span[contains(@class, 'custom-chips__icon') and contains(@class, 'close')]")
	private WebElement FilterCloseButtonSecrets;
	
	
	@FindBy(xpath="//div[contains(text(), 'wdwd')]")
	WebElement ValidateSecretSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidateSecretFilterData;
	
//	Method for Secrets
public void ClickSecretsModule() {
		
		waitForElementToBeVisible(SecretsModule);
		SecretsModule.click();
	}

public void ClickSecretsRefresh() {
	
	waitForElementToBeVisible(SecretsRefresh);
	SecretsRefresh.click();
}
	

public void ClickSecretPlusBtn() throws InterruptedException {
	
	waitForElementToBeVisible(SecretPlusBtn);
	SecretPlusBtn.click();
	Thread.sleep(2000);	
	SecretCancelBtn.click();
}
	

	
	public void matchSecretsPageColumns() {
		String excelFilePath = "./src/main/resources/ExcelFile/Secreats_grid.xlsx";
		int colNum = 0;

		// Getting data from Excel file and saving in expectedList
		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}

		// Getting data from UI and saving in actualList
		List<String> actualList = new ArrayList<>();
		for (WebElement component : tableSecretsPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌ Secret columns do not match.");
	}
	
	public void searchIconsecrets() throws InterruptedException, IOException {

//		searchIconsecrets.sendKeys("wdwd");
		String excelFilePath = "./src/main/resources/ExcelFile/Secreat_Search.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 0); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);

		Thread.sleep(3000);
		waitForElementToBeClickable(clickSearchIconSecrets);
		clickSearchIconSecrets.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconsecrets.sendKeys(Keys.ENTER);
		String Text = clickSearchIconSecrets.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Secrets is " + Text);
		closeSearchIconSecrets.click();
		
	}
	
    public void clickFilterIconSecrets() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconSecrets);
		clickFilterIconSecrets.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButtonSecrets.click();
		Thread.sleep(2000);
		filterclickNameSecrets.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterNameSecrets.sendKeys("secret1");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButtonSecrets.click();
		Thread.sleep(2000);	
		FilterCloseButtonSecrets.click();
		Thread.sleep(2000);	
		
	}
 
//	xpaths for Persistent Volumes
    
    
    @FindBy(xpath= "//span[text()='Persistent volumes']")
	WebElement IconPersistentVolumes;
  

    @FindBy(xpath= "//button[.//mat-icon[@fonticon='Refresh']]")
	WebElement RefreshIconPersistentVolumes;
  
    
    
	
	@FindBy(xpath = "//div[contains(@class, 'headercell-label') and contains(@class, 'ng-star-inserted')]")
	private List<WebElement> tablePersistentVolumesPage;
	
	@FindBy(xpath= "//input[@placeholder='Search by name']")
	WebElement searchIconPersistentVolumes;
	
	@FindBy(xpath="//bntv-icon//mat-icon[contains(@class, 'mat-icon') and contains(@class, 'Search')]")
	WebElement clickSearchIconPersistentVolumes;
	
	@FindBy(xpath="//bntv-search-box//mat-icon[@fonticon='close']")
	WebElement closeSearchIconPersistentVolumes;
	
	@FindBy(xpath="//button[.//mat-icon[@fonticon='filter_outline']]")
	WebElement clickFilterIconPersistentVolumes;

	@FindBy(xpath = "//mat-select[.//span[text()='Select']]")
	private WebElement selectFilterButtonPersistentVolumes;

	@FindBy(xpath = "//span[contains(@class, 'mdc-list-item__primary-text')]//span[contains(text(), 'Name')]")
	private WebElement filterclickNamePersistentVolumes;

	@FindBy(xpath = "//input[@placeholder='Name']")
	private WebElement FilterEnterNamePersistentVolumes;

	@FindBy(xpath = "//button[contains(@class, 'mat-flat-button') and .//span[text()='Apply']]")
	private WebElement FilterApplyButtonPersistentVolumes;
	
	@FindBy(xpath = "//span[contains(@class, 'custom-chips__icon') and contains(@class, 'close')]")
	private WebElement FilterCLOSEButtonPersistentVolumes;
	
	
	
	@FindBy(xpath="//div[contains(text(), 'vco01-wrk-vs-code-pool-pvc')]")
	WebElement ValidatePersistentVolumesSearchData;
	
	@FindBy(xpath="//div[contains(@class, 'chip-ellip')]")
	WebElement ValidatePersistentVolumesFilterData;
	
//	Method for Persistent Volumes
public void ClickIconPersistentVolumes() {
		
		waitForElementToBeVisible(IconPersistentVolumes);
		IconPersistentVolumes.click();
	}
	
public void ClickRefreshIconPersistentVolumes() {
	
	waitForElementToBeVisible(RefreshIconPersistentVolumes);
	IconPersistentVolumes.click();
}

	
	public void matchPersistentVolumnsPageColumns() {
		String excelFilePath = "./src/main/resources/ExcelFile/Persistent_Volumes_demo.xlsx";
		int colNum = 0;

		// Getting data from Excel file and saving in expectedList
		List<String> expectedList = new ArrayList<>();
		try {
			expectedList = ExcelReader.readColumnData(excelFilePath, colNum);
		} catch (IOException e) {
			System.err.println("Error reading Excel file: " + e.getMessage());
			e.printStackTrace();
		}

		// Getting data from UI and saving in actualList
		List<String> actualList = new ArrayList<>();
		for (WebElement component : tablePersistentVolumesPage) {
			String componentText = component.getText().trim();
			if (!componentText.isEmpty()) { // Ignore empty strings
				actualList.add(componentText);
			}
		}

		// Printing both lists before comparison
		System.out.println("\nExpected List (From Excel): " + expectedList);
		System.out.println("Actual List (From UI): " + actualList);

		// Comparing both lists and failing test if they don't match
		Assert.assertEquals(actualList, expectedList, "❌  Persistent Volumes columns do not match.");
	}
	
	public void searchIconPersistentVolumes() throws InterruptedException, IOException {

//		searchIconPersistentVolumes.sendKeys("code");
		String excelFilePath = "./src/main/resources/ExcelFile/Secreat_Search.xlsx";
		 
		System.out.println("file : " + excelFilePath);
 
		// Fetch only the first row from column 1 (0-based index)
		String searchValue = ExcelDataReader.readSingleRowData(excelFilePath, 0, 0, 0); // Sheet 0, Column 0, Row 1
 
		System.out.println("value : " + searchValue);

		Thread.sleep(3000);
		waitForElementToBeClickable(searchIconPersistentVolumes);
		searchIconPersistentVolumes.sendKeys(searchValue);
		Thread.sleep(3000);
		searchIconPersistentVolumes.sendKeys(Keys.ENTER);
		String Text = searchIconPersistentVolumes.getText();
		Thread.sleep(3000);
		System.out.println("The name of the searched Secrets is " + Text);
		closeSearchIconPersistentVolumes.click();
		
	}
	
    public void clickFilterIconPersistentVolumes() throws InterruptedException {
		
		waitForElementToBeClickable(clickFilterIconPersistentVolumes);
		clickFilterIconPersistentVolumes.click();
		Thread.sleep(3000);
		System.out.println("clicked on filter icon");
		selectFilterButtonPersistentVolumes.click();
		Thread.sleep(2000);
		filterclickNamePersistentVolumes.click();
		System.out.println("selected name in filter");
		Thread.sleep(2000);
		FilterEnterNamePersistentVolumes.sendKeys("vco01-wrk-vs-code-pool-pvc");
		System.out.println("entered text in filter");
		Thread.sleep(2000);
		FilterApplyButtonPersistentVolumes.click();
		Thread.sleep(2000);	
		FilterCLOSEButtonPersistentVolumes.click();
		Thread.sleep(2000);	
		
	}
    
//	Assertion Methods for Nodepool page
	
	public String ValidateConfigurationModuleName() {
		
		waitForElementToBeVisible(ValidateConfigurationModuleName);
		return ValidateConfigurationModuleName.getText();
	}
	
  public String ValidateNodepoolSearchData() {
		
		waitForElementToBeVisible(ValidateNodepoolSearchData);
		return ValidateNodepoolSearchData.getText();
	}
  
  public String ValidateNodepoolFilterData() {
		
		waitForElementToBeVisible(ValidateNodepoolFilterData);
		return ValidateNodepoolFilterData.getText();
	}
  
//	Assertion Methods for Associated Bucket page
  
  public String ValidateAssociatedBucketSearchData() {
		
		waitForElementToBeVisible(ValidateAssociatedBucketSearchData);
		return ValidateAssociatedBucketSearchData.getText();
	}
  
  public String ValidateAssociatedBucketFilterData() {
		
		waitForElementToBeVisible(ValidateAssociatedBucketFilterData);
		return ValidateAssociatedBucketFilterData.getText();
	}
  
//	Assertion Methods for Secret page

  public String ValidateSecretSearchData() {
		
		waitForElementToBeVisible(ValidateSecretSearchData);
		return ValidateSecretSearchData.getText();
	}

  public String ValidateSecretFilterData() {
		
		waitForElementToBeVisible(ValidateSecretFilterData);
		return ValidateSecretFilterData.getText();
	}
  
//	Assertion Methods for Persistent Volumes page

public String ValidatePersistentVolumesSearchData() {
		
		waitForElementToBeVisible(ValidatePersistentVolumesSearchData);
		return ValidatePersistentVolumesSearchData.getText();
	}

public String ValidatePersistentVolumesFilterData() {
		
		waitForElementToBeVisible(ValidatePersistentVolumesFilterData);
		return ValidatePersistentVolumesFilterData.getText();
	}


}
