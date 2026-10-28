package StepDef;

import org.openqa.selenium.firefox.FirefoxDriver;

import Helper.Config;
import Helper.Utlis;
import Pages.Ajoutpanier;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AjoutPanierStepDef {
	
	@Given("utlisateur est dans la page  produit")
	public void utlisateur_est_dans_la_page_produit() throws Exception {
		Config.driver = new FirefoxDriver();
		Config.maxwin();
		Config.driver.get(Utlis.getProperty("productlink"));
	}
	@When("lutilisateur est cliquer sur le couleur {string} et clique sur la taille {string} et cliquer sur ajout au panier")
	public void lutilisateur_est_cliquer_sur_le_couleur_et_clique_sur_la_taille_et_cliquer_sur_ajout_au_panier(String string, String string2) {
		Ajoutpanier panier = new Ajoutpanier();
		panier.ajoutproduct(string, string2);
		
	}
	@Then("utlisateur est dirige vers la page panier et verifier lajout de produit {string}")
	public void utlisateur_est_dirige_vers_la_page_panier_et_verifier_lajout_de_produit(String string) {
		Ajoutpanier panier = new Ajoutpanier();
		panier.verification(string);
		Config.driver.quit();
	}

}
