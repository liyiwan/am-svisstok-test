package tests.page.ios;

import java.awt.Rectangle;

import com.annotation.FindBy;
import com.element.UIView;
import com.mobile.driver.nativedriver.NativeDriver;
import com.mobile.driver.page.PageFactory;
import com.mobile.driver.wait.Sleeper;

import tests.page.FavoritePage;

public class FavoritePageIos extends FavoritePage{

	public FavoritePageIos(NativeDriver driver) {
		super(driver);
	}
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/textfield[1]")
	private UIView searchFiled;
	
	@FindBy(locator = "//window[2]/toolbar[1]/button[1]")
	private UIView doneButton;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]")
	private UIView webview;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[5]")
	private UIView contactName;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[3]/link[1]")
	private UIView searchResult;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/text[2]")
	private UIView timerCall;
	
	@FindBy(locator = "//window[1]/scrollview[1]/webview[1]/link[9]/link[1]")
	private UIView callingButton;

	@Override
	public void checkPage() {
		// TODO Auto-generated method stub
		
	}
	
	public void searchContacts(String text){
		   searchFiled.touch();
		   searchFiled.type(text);
		   doneButton.touch();
	   }
	
    public void clickSearchResult(String name){
		   Rectangle point = webview.getLocation();
			double y = 113;
			webview.touchWithCoordinates(point.getX(), point.getY() + y);
	   }
 
   public String getContactName(){
		return contactName.getAttribute("name");
	}
   
	public void clickEditContacts(){
		Rectangle point = webview.getLocation();
		double x = 270;
		webview.touchWithCoordinates(point.getX() + x, point.getY());
		
	}
	
	
	public void clickDeletefromList(){
		Rectangle point = webview.getLocation();
		double x = 116;
		webview.touchWithCoordinates(point.getX() + x, point.getY());
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
		
	public void clickDelete(){
		//delete.touch();
		Rectangle point = webview.getLocation();
		double x = 20;
		double y = 245;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}
	
	
	public void clickCall(){
		Rectangle point = webview.getLocation();
		double x = 160;
		double y = 406;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}
	
	public void clickCallingButton(){
		callingButton.touch();
		Sleeper.SYSTEM_SLEEPER.sleep(3000);
	}
	
	public void cancelCall() {
		Rectangle point = webview.getLocation();
		double x = 24;
		double y = 412;
		webview.touchWithCoordinates(point.getX() + x, point.getY() + y);
	}
	
	public String getTimer() {
		return timerCall.getAttribute("label");
	}

}