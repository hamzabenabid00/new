package Pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class ProduitCollection {

    @FindBy(xpath = "//h5[contains(@class,'product-item-name')]//a")
    private List<WebElement> produits;

    @FindBy(xpath = "/html/body/main/div/section/div[2]/div/div[5]/div[2]/div/div/h1")
    private WebElement produitTitre;

    public ProduitCollection() {
        PageFactory.initElements(Config.driver, this);
    }

    public void findproduct(String nomProduit) {
        WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(20));
        boolean produitTrouve = false;

        for (WebElement p:produits) {
            for (WebElement produit : produits) {
                if (produit.getText().contains(nomProduit)) {
                    wait.until(ExpectedConditions.visibilityOf(produit));
                    produit.click();
                    produitTrouve = true;
                    return;
                }
            }
            
        }

     
    }

    public void verification(String titre) {
      
        Assert.assertTrue(produitTitre.getText().contains(titre));
    }
}