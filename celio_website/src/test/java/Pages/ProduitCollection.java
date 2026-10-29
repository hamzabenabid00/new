package Pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class ProduitCollection {

    @FindBy(xpath = "//a[contains(normalize-space(.), \"Pantalon straight 100% lin - bleu foncé\")]")
    WebElement produit;

    @FindBy(xpath = "//h1[contains(normalize-space(.), \"Pantalon straight 100% lin - bleu foncé\")]")
    WebElement produitTitre;

    public ProduitCollection() {
        PageFactory.initElements(Config.driver, this);
    }

    public void clickProduct(String nomProduit) {
        WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(produit)).click();
    }

    public void verification(String titre) {
        WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(produitTitre));
        Assert.assertTrue(produitTitre.getText().contains(titre));
    }
}
