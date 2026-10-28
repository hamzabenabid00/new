package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class Ajoutpanier {
	@FindBy(xpath="/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[2]/div/div/div[1]/div/div")
	List<WebElement>couleurs;
	@FindBy(xpath="/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/div[2]/form/div[2]/div/div/div[2]/div/div")
	List<WebElement>tailles;
	@FindBy(xpath="/html/body/div[2]/div/div[1]/div[2]/div/div[2]/div/div[2]/div/div/button")
	WebElement voirpanier ;
	@FindBy(id="product-addtocart-button")
	WebElement addbtn ;
	
	public Ajoutpanier() {
		PageFactory.initElements(Config.driver, this);
	}
	
	

	
	
	
}
