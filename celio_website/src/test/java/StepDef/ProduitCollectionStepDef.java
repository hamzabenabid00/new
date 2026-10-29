package StepDef;

import org.openqa.selenium.firefox.FirefoxDriver;

import Helper.Config;
import Helper.Utlis;
import Pages.ProduitCollection;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProduitCollectionStepDef {

    @Given("utilisateur est dans la page collection")
    public void utilisateur_est_dans_la_page_collection() throws Exception {
        Config.driver = new FirefoxDriver();
        Config.maxwin();
        Config.driver.get(Utlis.getProperty("collection"));
    }

    @When("lutilisateur clique sur le produit {string}")
    public void lutilisateur_clique_sur_le_produit(String produit) {
        ProduitCollection page = new ProduitCollection();
        page.clickProduct(produit);
    }

    @Then("utlisateur est dirige vers la page produit {string}")
    public void utlisateur_est_dirige_vers_la_page_produit(String titre) {
        ProduitCollection page = new ProduitCollection();
        page.verification(titre);
        Config.driver.quit();
    }
}
