package pages1;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Deleteitem {
	
	@FindBy(xpath = "//button[@class='confirm btn btn-lg btn-primary']")
	WebElement okbtn;
	
	
	@FindBy(xpath = "//a[contains(text(),'Deletee')]")
	//@FindBy(css = "a[onclick*='deleteItem']")
	WebElement deleteitem;
	
	
	
public Deleteitem(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
		
	}
public void returntohome() {
	okbtn.click();
	
}
public void deleteitem() {
	deleteitem.click();
	
}

}
