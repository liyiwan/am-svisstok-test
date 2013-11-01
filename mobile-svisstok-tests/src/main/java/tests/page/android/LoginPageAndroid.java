package tests.page.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.Select;

import com.annotation.FindBy;
import com.element.UIView;
import com.ios.AppiumDriver;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import tests.page.CallPage;
import tests.page.LoginPage;

public class LoginPageAndroid extends LoginPage{

	@FindBy(locator = "//input[@id='loginView-login']")
	public UIView loginTextfield;

	@FindBy(locator = "//input[@id='loginView-password']")
	public UIView passwordTextfield;

	@FindBy(locator = "//div[@class='right']/select[@id='loginView-savepass']/ancestor::div[@class='right']")
	private UIView savePasswordSlider;

	@FindBy(locator = "//a[@id='loginView-btn-login']")////a[@id='loginView-btn-login']/ancestor::div[@class='ui-block-a']
	private UIView loginButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView errorMessage;

	
	//driver.switchTo().window("NATIVE_APP");
	
	public LoginPageAndroid(NativeDriver driver) {
		super(driver);
		AppiumDriver.class.cast(driver).getDriver().switchTo().window("WEBVIEW");
	}

	@Override
	public void savePasswordFalse() {
		savePasswordSlider.touch();
		//System.out.println(AppiumDriver.class.cast(driver).getDriver().getPageSource());

	}

	@Override
	public void clickLogin() {
		loginButton.touch();
		//System.out.println(AppiumDriver.class.cast(driver).getDriver().getPageSource());
//		WebDriver driver2 = AppiumDriver.class.cast(driver).getDriver();
//		WebElement element = driver2.findElement(By.xpath(loginButton.getFoundBy()));
//		Actions action = new Actions(driver2);
//		action.click(element).build().perform();
	}

	@Override
	public CallPageAndroid simpleLogin(String login, String password) {
		Sleeper.SYSTEM_SLEEPER.sleep(15000);
		inputLoginTextfield(login);
		inputPasswordTextfield(password);
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		savePasswordFalse();
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		clickLogin();
	//	System.out.println(AppiumDriver.class.cast(driver).getDriver().getPageSource());
	//	AppiumDriver.class.cast(driver).getDriver().getPageSource();
		return PageFactory.initElements(driver, CallPageAndroid.class);
	}

	public String getLoginFieldText() {
		return loginTextfield.getAttribute("value");
	}
	
	public String getPasswordFieldText() {
		return passwordTextfield.getAttribute("value");
	}
	
	@Override
	public void inputLoginTextfield(String text) {
		loginTextfield.clear();
		loginTextfield.type(text);
		
	}

	@Override
	public boolean isErrorMessageAppears() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void clearField(UIView element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inputPasswordTextfield(String text) {
		passwordTextfield.clear();
		passwordTextfield.type(text);
		
	}

	@Override
	public void checkPage() {
		loginTextfield.waitForElement(WAIT_FOR_ELEMENT_TIMEOUT);
	}

}