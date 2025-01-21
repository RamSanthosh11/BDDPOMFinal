package stepdefs1;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base1.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages1.Deleteitem;
import pages1.CartPage;
import pages1.CheckOutPage;
import pages1.LoginPage;
import pages1.ProductListPage;

public class ItemOrderDef {

	WebDriver driver;
	 LoginPage loginPage;
	 ProductListPage ListPage;
	 CartPage cartpage;
	 CheckOutPage checkOutPage;
	 Deleteitem deleteitem;

    public ItemOrderDef() {
    	 TestBase.initDriver();
	        driver = TestBase.getDriver();
	        loginPage = new LoginPage(driver);
	        ListPage = new ProductListPage(driver);
	        cartpage = new CartPage(driver);
	        checkOutPage = new CheckOutPage(driver);
	        deleteitem = new Deleteitem(driver);

    }

    @Given("User is on login Page")
    public void user_is_on_login_page() {
    	TestBase.openUrl("https://www.demoblaze.com/");
    }

    /*
    @When("User enters {string} and {string}")
    public void user_enters_and(String struser, String strpwd) {
    	loginPage.validLogin(struser, strpwd);
        loginPage.userlogin();
    }
    */
    @When("User enters credentials")
    public void user_enters_and( io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> user =  dataTable.asMaps();
		String struser = user.get(0).get("username");
		String strpwd = user.get(0).get("password");
		loginPage.validLogin(struser, strpwd);
		loginPage.userlogin();
    }

  @Given("User should be on Home page")
    public void user_should_be_on_home_page() throws InterruptedException {
	  Thread.sleep(1000);
  	  boolean isOnProductsPage = ListPage.isOnProducts();
  	  Assert.assertTrue(isOnProductsPage);
        
    }

    @When("User add item to cart")
    public void user_add_item_to_cart() throws InterruptedException {
    	ListPage.addToCart();
	    Thread.sleep(1000);
    	
    }

    @Then("Item must be added")
    public void item_must_be_added() {
    	Assert.assertEquals(ListPage.confirmbyalert(), "Product added.");
    }

    @Given("User is on cart page")
    public void user_is_on_cart_page() throws InterruptedException {
    	Thread.sleep(1000);
		  cartpage.checkoutItems();

    }

    @When("User do checkout")
    public void user_do_checkout() throws InterruptedException {
    	Thread.sleep(1000);
    	 boolean isOnProductsPage = cartpage.isItemAdded();
	      Assert.assertTrue(isOnProductsPage);
 
    }

    @Then("Should navigate to Checkout page")
    public void should_navigate_to_checkout_page() throws InterruptedException {
    	Thread.sleep(2000);
    	 checkOutPage.checkoutInfo("Ram","India", "Hyderabad", "522066", "06","1999");
	      checkOutPage.checkoutOrder();
	      Assert.assertEquals(checkOutPage.Succeessmsg(), "Thank you for your purchase!");

        
    }

    @Given("Cart must have items")
    public void cart_must_have_items() throws InterruptedException {
    	    Thread.sleep(1000);
		    deleteitem.returntohome();
        
    }
    @When("User delete an item")
    public void user_delete_an_item() throws InterruptedException {
    	  Thread.sleep(4000);
    	    ListPage.addToCart();
		    cartpage.checkoutItems();
        
    }
    @Then("Should delete item from cart")
    public void should_delete_item_from_cart() throws InterruptedException {
    	    Thread.sleep(3000);
		    deleteitem.deleteitem();
        
    }
    
}
