package StepDef;

import org.openqa.selenium.firefox.FirefoxDriver;

import Helper.Config;
import Helper.Utlis;
import Pages.ProduitCollection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProduitCollectionStepDef {

    @Given("utilisateur est sur la page collection")
    public void utilisateur_est_sur_la_page_collection() throws Exception {
        Config.driver = new FirefoxDriver();
        Config.maxwin();
        Config.driver.get(Utlis.getProperty("productcollection"));
    }

    @When("lutilisateur clique sur le produit {string}")
    public void lutilisateur_clique_sur_le_produit(String nomProduit) {
        ProduitCollection produit = new ProduitCollection();
        produit.findproduct(nomProduit);
    }

    @Then("utlisateur est redirige vers la page produit {string}")
    public void utlisateur_est_redirige_vers_la_page_produit(String nomProduit) {
        ProduitCollection produit = new ProduitCollection();
        produit.verification(nomProduit);
        Config.driver.quit();
    }
}
