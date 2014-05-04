package tests.page.ios;

import java.awt.Rectangle;

import tests.page.CallPage;
import tests.page.SettingsPage;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

public class SettingsPageIos extends SettingsPage {

	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/slider[3]")
	private UIView autoLoginSlider;
	
	@FindBy(locator = "Все контакты")
	private UIView allContacts;
	
	@FindBy(locator = "Контакты в Swisstok")
	private UIView swisstokContacts;
	
	@FindBy(locator = "Избранные")
	private UIView favourContacts;
	
	@FindBy(locator = "Сохраненные номера")
	private UIView savedContacts;
	
	@FindBy(locator = "Заблокированные")
	private UIView block;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[22]")
	private UIView encryption;
	
	@FindBy(locator = "//window[2]/picker[1]/pickerwheel[1]")
	private UIView popUpMenu;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[13]/link[1]")
	private UIView callTab;
	

	public SettingsPageIos(NativeDriver driver) {
		super(driver);
	}

	@Override
	public void checkPage() {
	}

	@Override
	public void setAutoLogin(boolean flag) {
		if (flag) {
			if (autoLoginSlider.getAttribute("value").equals("0.00")) {
				autoLoginSlider.touch();
			}
		}
		else {
			if (autoLoginSlider.getAttribute("value").equals("1")) {
				autoLoginSlider.touch();
			}
		}
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public boolean isAutoLoginFlagEnable() {
		return autoLoginSlider.getAttribute("value").equals("0.00");
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageIos clickAllContacts(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = allContacts.getLocation();
		allContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}
	
	//use coordinats, because dynamic xPath
	@Override
	@SuppressWarnings("unchecked")
	public CardContactsPageIos clickSwisstokContacts(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = swisstokContacts.getLocation();
		swisstokContacts.touchWithCoordinates(point.getX(), 200);
		return PageFactory.initElements(driver, CardContactsPageIos.class);
	}
	@SuppressWarnings("unchecked")
	@Override
	public BlockPageIos clickBlock() {
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = block.getLocation();
		block.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, BlockPageIos.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public FavoritePageIos clickFavorite(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = favourContacts.getLocation();
		favourContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, FavoritePageIos.class);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public SavedContactsPageIos clickSavedContacts(){
		Sleeper.SYSTEM_SLEEPER.sleep(1000);
		Rectangle point = savedContacts.getLocation();
		savedContacts.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, SavedContactsPageIos.class);
	}

	@Override
	public void setZRTPconnection() {
		Rectangle point = encryption.getLocation();
		encryption.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		point = popUpMenu.getLocation();
		popUpMenu.touchWithCoordinates(point.getX(), point.getY() + 216/2 + 80);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}

	@Override
	public void setSRTPconnection() {
		Rectangle point = encryption.getLocation();
		encryption.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		point = popUpMenu.getLocation();
		popUpMenu.touchWithCoordinates(point.getX(), point.getY() + 216/2 + 30);
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
	}


	@Override
	public CallPage clickCall() {
		Rectangle point = callTab.getLocation();
		callTab.touchWithCoordinates(point.getX(), point.getY());
		return PageFactory.initElements(driver, CallPageIos.class);
	}

	@Override
	public void setConnectionByDefault() {
		Rectangle point = encryption.getLocation();
		encryption.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		point = popUpMenu.getLocation();
		popUpMenu.touchWithCoordinates(point.getX(), point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(2000);
		clickCall();
	}

}
