
package nawatTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import base.BaseSetup;
import pages.AuditActionsPage;
import pages.ConfigurationPage;
import pages.DataHub;
import pages.Datasets;
import pages.DevToolKitPage;
import pages.KeyManagementDemoPage;
import pages.MarketplaceDemoPage;
import pages.MarketplacePage;
import pages.OrganizationUnitPage;
import pages.OrganizationalUnit_Demo;
import pages.ProjectPage;
import pages.ResourcesKubernetesPage;
import pages.ResourcesObjectStoragePage;
import pages.ResourcesSqlPage;
import pages.ResourcesVMPage;
import pages.SideMenuBar;
import pages.UsersPage;
import pages.ConfigurationDemo;
import utils.ExtentListener;


public class ConfigurationDemoTest extends BaseSetup  {
	
	
	private SideMenuBar sideMenuBar;
	private OrganizationUnitPage organizationUnitPage;
	private ProjectPage projectPage;
	private DevToolKitPage devToolKitPage;
	private ConfigurationPage configurationPage;
	private ResourcesVMPage resourcesVMPage;
	private ResourcesKubernetesPage resourcesKubernetesPage;
	private ResourcesObjectStoragePage resourcesObjectStoragePage;
	private ResourcesSqlPage resourcesSqlPage;
	private MarketplacePage marketplacePage;
	private KeyManagementDemoPage keyManagement;
	private AuditActionsPage auditActionsPage;
	private UsersPage usersPage;
	private ConfigurationDemo configurations;
	

	
	

@Test(priority = 1)
public void searchIconKeyManagement() throws InterruptedException {
	sideMenuBar = new SideMenuBar(driver);
	sideMenuBar.clickToggle();
	//sideMenuBar.KeyManagement();
}

@Test(priority = 2)
public void validatestClickCongiguration() throws InterruptedException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickCongiguration();
	Thread.sleep(3000);
	System.out.println("clicked on configuration module");

}


@Test(priority = 3)
public void validatestClickCongigurationRefreshBtn() throws InterruptedException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickRefreshBtn();
	Thread.sleep(3000);
	System.out.println("clicked on configuration refresh Btn");

}

@Test(priority = 4)
public void validatestCreateBtn() throws InterruptedException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickCongigurationRPlusBtn();
	Thread.sleep(3000);
	System.out.println("clicked on configuration Plus Btn");

}

@Test(priority = 5)
public void validatestClickCongigurationCongigurationCancelBtn() throws InterruptedException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickCongigurationCongigurationCancelBtn();
	Thread.sleep(3000);
	System.out.println("clicked on configuration cancel Btn");

}
@Test(priority = 6)
public void validatestclickFilterIconNodepool() throws InterruptedException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.clickFilterIconNodepool();
	Thread.sleep(3000);
	System.out.println("clicked on configuration filter Btn");

}



@Test(priority = 7)
public void validatestsearchIconNodepool() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.searchIconNodepool();
	Thread.sleep(3000);
	System.out.println("clicked on configuration search Btn");

}


@Test(priority = 8)
public void validatematchNodepoolPageColumns() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.matchNodepoolPageColumns();
	Thread.sleep(3000);
	//System.out.println("clicked on configuration filter Btn");

}


///////Associated Bucktes
@Test(priority = 9)
public void validateClickAssociatedBuckets() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickAssociatedBuckets();
	Thread.sleep(3000);
	System.out.println("clicked on configuration AssociatedBuckets Btn");

}


@Test(priority = 10)
public void validateClickAssociate_RefreshBtn() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickAssociate_RefreshBtn();
	Thread.sleep(3000);
	System.out.println("clicked on Refresg Btn");

}

@Test(priority = 11)
public void validateClickAssociate_PlusBtn() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickAssociate_PlusBtn();
	Thread.sleep(3000);
	System.out.println("clicked on create Btn");

}
//@Test(priority = 12)
//public void validatematchABPageColumns() throws InterruptedException, IOException {
//	configurations = new ConfigurationDemo(driver);
//	
//	configurations.matchABPageColumns();
//	Thread.sleep(3000);
//	System.out.println("clicked on create Btn");
//
//}


/////secrets
///
@Test(priority = 13)
public void validateClickSecretsModule() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickSecretsModule();
	Thread.sleep(3000);
	System.out.println("clicked on secreats module");

}


@Test(priority = 14)
public void validateClickSecretsRefresh() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickSecretsRefresh();
	Thread.sleep(3000);
	System.out.println("clicked on refresh Btn");

}

@Test(priority = 15)
public void validateClickSecretPlusBtn() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickSecretPlusBtn();
	Thread.sleep(3000);
	System.out.println("clicked on create Btn");

}

@Test(priority = 16)
public void validatematchSecretsPageColumns() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.matchSecretsPageColumns();
	Thread.sleep(3000);
	//System.out.println("clicked on create Btn");

}


@Test(priority = 17)
public void validaclickFilterIconSecrets() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.clickFilterIconSecrets();
	Thread.sleep(3000);
	System.out.println("clicked on filter Btn");

}

@Test(priority = 18)
public void validatesearchIconsecrets() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.searchIconsecrets();
	Thread.sleep(3000);
	System.out.println("clicked on search Btn");

}


//////persistent voulmes

@Test(priority = 19)
public void validateClickIconPersistentVolumes() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickIconPersistentVolumes();
	Thread.sleep(3000);
	System.out.println("clicked on persistent volumes Btn");

}



@Test(priority = 20)
public void validateClickRefreshIconPersistentVolumes() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.ClickRefreshIconPersistentVolumes();
	Thread.sleep(3000);
	System.out.println("clicked on persistent volumes Btn");

}


@Test(priority = 21)
public void validatesearchIconPersistentVolumes() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.searchIconPersistentVolumes();
	Thread.sleep(3000);
	System.out.println("clicked on persistent volumes Btn");

}

@Test(priority = 22)
public void validateclickFilterIconPersistentVolumes() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.clickFilterIconPersistentVolumes();
	Thread.sleep(3000);
	System.out.println("clicked on persistent volumes Btn");

}




@Test(priority = 23)
public void validatematchPersistentVolumnsPageColumns() throws InterruptedException, IOException {
	configurations = new ConfigurationDemo(driver);
	
	configurations.matchPersistentVolumnsPageColumns();
	Thread.sleep(3000);
	System.out.println("clicked on persistent volumes Btn");

}



}

