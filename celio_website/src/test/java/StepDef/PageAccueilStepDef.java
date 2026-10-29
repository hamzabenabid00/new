package StepDef;

import org.openqa.selenium.firefox.FirefoxDriver;

import Helper.Config;
import Helper.Utlis;
import Pages.PageAccueil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PageAccueilStepDef {
	@Given("utlisateur est dans la page  daccueil")
	public void utlisateur_est_dans_la_page_daccueil() throws Exception {
		Config.driver = new FirefoxDriver();
		Config.maxwin();
		Config.driver.get(Utlis.getProperty("homepage"));
	}
	@When("lutilisateur est cliquer sur le menu {string} et cliquer sur submenu {string}")
	public void lutilisateur_est_cliquer_sur_le_menu_et_cliquer_sur_submenu(String menutest, String submenutest) {
	    PageAccueil page = new PageAccueil();
	    page.clickonmune(menutest, submenutest);
	}
	@Then("utlisateur est dirige vers la page  {string}")
	public void utlisateur_est_dirige_vers_la_page(String Link) {
		 PageAccueil page = new PageAccueil();
		 page.verification(Link);
		Config.driver.quit();
	}

}
