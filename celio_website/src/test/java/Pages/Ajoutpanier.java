package Pages;

import static org.junit.Assert.assertTrue;

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
	@FindBy(xpath="/html/body/main/div/section/div[2]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[1]/div/strong/a")
	WebElement textv;
	public Ajoutpanier() {
		PageFactory.initElements(Config.driver, this);
	}

	public void ajoutproduct(String ccouleur, String ttailles) {

	    boolean couleurTrouvee = false;
	    boolean tailleTrouvee = false;

	    // 1. Select the color
	    for (WebElement couleur : couleurs) {

	        String colorName = couleur.getAttribute("option-label");

	        if (colorName != null &&
	            colorName.equalsIgnoreCase(ccouleur)) {

	            Config.attent(2);
	            couleur.click();
	            couleurTrouvee = true;
	            break;
	        }
	    }

	   
	    for (WebElement taille : tailles) {

	        String sizeName = taille.getAttribute("option-label");

	        if (sizeName != null && sizeName.equalsIgnoreCase(ttailles)) {

	            tailleTrouvee = true;

	            // Click only if the size is not already selected
	            String selected = taille.getAttribute("aria-checked");

	            if (!"true".equals(selected)) {
	                taille.click();
	            }

	            break;
	        }
	    }

	    // 3. Add to cart only if both options exist
	    addbtn.click();
	}
	public void verification(String text) {
		voirpanier.click();
		Config.attent(2);
		assertTrue(textv.getText().contains(text));
	}
	
	
	
}
