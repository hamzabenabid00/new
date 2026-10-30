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
    @FindBy(xpath = "//a[contains(., 'T-shirt regular 100% coton manches longues - marron')]")
    WebElement produit;

    @FindBy(xpath = "//h1[contains(., 'T-shirt regular 100% coton manches longues - marron')]")
    WebElement produitTitre;

    public ProduitCollection() {
        PageFactory.initElements(Config.driver, this);
    }

    public void clickOnProduct(String nomProduit) {
        WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(produit)).click();
    }

    public void verification(String expectedText) {
        WebDriverWait wait = new WebDriverWait(Config.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(produitTitre));
        Assert.assertTrue(produitTitre.getText().contains(expectedText));
    }
}
