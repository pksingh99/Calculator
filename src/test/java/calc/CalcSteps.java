package calc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.TestCase;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CalcSteps extends TestCase{
	int num1, num2;
	private WebDriver driver;
	  private String baseUrl;
	@Given("^user enter firstNum as (\\d+) and secondNum as (\\d+)$")
	public void userInput(int arg1, int arg2) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		num1 = arg1;
		num2 = arg2;
		driver = new FirefoxDriver();
	    baseUrl = "http://ata123456789123456789.appspot.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl + "/");
	    driver.findElement(By.id("ID_nameField1")).clear();
	    driver.findElement(By.id("ID_nameField1")).sendKeys(num1+"");
	    driver.findElement(By.id("ID_nameField2")).clear();
	    driver.findElement(By.id("ID_nameField2")).sendKeys(num2+"");
	}

	@When("^Click on \"([^\"]*)\"$")
	public void Click_on(String arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		if(arg1.equals("Add"))
		{
			driver.findElement(By.id("gwt-uid-1")).click();
		}
		else if(arg1.equals("Mul"))
		{
			driver.findElement(By.id("gwt-uid-2")).click();
		}
	driver.findElement(By.id("ID_calculator")).click();	
	}

	@Then("^result should be (\\d+)$")
	public void result_should_be(int arg1) throws Throwable {
	    // Express the Regexp above with the code you wish you had
	    //throw new PendingException();
		//Calculator obj = new Calculator();
		String result = driver.findElement(By.id("ID_nameField3")).getAttribute("value");
		assertEquals(arg1, Integer.parseInt(result));
		driver.close();
	}
}
