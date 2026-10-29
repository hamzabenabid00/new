package Pages;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helper.Config;

public class PageAccueil {
	@FindBy(xpath="/html/body/main/div/header/div[2]/div/div/div/div[1]/div/div[1]/nav/ul/li/a")
	List<WebElement>menus;
	@FindBy(xpath="/html/body/main/div/header/div[2]/div/div/div/div[1]/div/div[1]/nav/ul/li[2]/ul/li/div/div/div[1]/ul/li/a")
	List<WebElement>submenus;
	@FindBy(xpath="/html/body/main/div/div[2]/div/ul/li[3]")
	WebElement linkverif ;
	
	public PageAccueil() {
		PageFactory.initElements(Config.driver, this);
		}
	public void  clickonmune(String menutitle , String submenutitle) {
		 WebDriverWait wait = new WebDriverWait(
		            Config.driver, Duration.ofSeconds(10)
		        );

	        Actions action = new Actions(Config.driver);

        // Wait for the menus to be visible and available
        wait.until(ExpectedConditions.visibilityOfAllElements(menus));

        WebElement menu = null;

        for (WebElement m : menus) {
            if (m.getText() != null && m.getText().trim().equalsIgnoreCase(menutitle)) {
                menu = m;
                break;
            }
        }

        if (menu == null) {
            throw new NoSuchElementException("Menu not found: " + menutitle);
        }

        action.moveToElement(menu).perform();

        // Wait for the submenus to become visible
        wait.until(ExpectedConditions.visibilityOfAllElements(submenus));

        WebElement submenu = null;

        for (WebElement s : submenus) {
            if (s.getText() != null && s.getText().trim().equalsIgnoreCase(submenutitle)) {
                submenu = s;
                break;
            }
        }

        if (submenu == null) {
            throw new NoSuchElementException("Submenu not found: " + submenutitle);
        }

        wait.until(ExpectedConditions.elementToBeClickable(submenu));
        submenu.click();
	
	}
	

    public void verification(String expectedText) {

        WebDriverWait wait = new WebDriverWait(
            Config.driver, Duration.ofSeconds(10)
        );

        wait.until(ExpectedConditions.visibilityOf(linkverif));

        Assert.assertTrue(  
            linkverif.getText().contains(expectedText)
        );
    }
	

}