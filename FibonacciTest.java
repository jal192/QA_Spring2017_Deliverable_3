/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 10
	
	Requirements Tested: 2, 4, 5
	
	Requirement #2 is implicitly tested by navigating to the Fibonacci page from the app homepage.
*/

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.*;

public class FibonacciTest {
	static WebDriver driver;
	private String baseUrl;
	
	
	// Start at the app homepage for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	
	// #######################################
	// ############# VALID INPUT #############
	// #######################################
	
	
	// Tests requirement #4
	// Tests explicit boundary value 1.
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters a valid integer between 1 and 100 that the correct results are displayed.
	@Test
	public void FibonacciValidInput1() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("1");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	// Tests requirement #4
	// Tests explicit boundary value 100.
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters a valid integer between 1 and 100 that the correct results are displayed.
	@Test
	public void FibonacciValidInput100() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("100");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 100 is 354224848179261915075!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #4
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters a valid integer between 1 and 100 that the correct results are displayed.
	@Test
	public void FibonacciValidInput30() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("30");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 30 is 832040!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #4
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters a valid integer between 1 and 100 that the correct results are displayed.
	@Test
	public void FibonacciValidInput50() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("50");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 50 is 12586269025!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// #########################################
	// ############# INVALID INPUT #############
	// #########################################
	
	// Tests requirement #5
	// Tests explicit boundary value 0.
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters and submits an integer less than 1 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInput0() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("0");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 0 is 0!", driver.findElement(By.cssSelector("h2")).getText());
	}	
	
	
	// Tests requirement #5
	// Tests explicit boundary value 101.
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters and submits an integer greater than 100 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInput101() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("101");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 101 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	
	// Tests requirement #5
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters and submits an integer less than 1 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputLessThan1() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("-713");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of -713 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #5
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters and submits an integer greater than 100 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputGreaterThan100() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("777");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 777 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	
	// Tests requirement #5
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters a float number that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputFloat() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("1.234567");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 1.234567 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #5
	
	// Given the app homepage, navigate to the Fibonacci page.
	// Ensure that if the user enters a string/text that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputString() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("Party Time!");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of Party Time! is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}