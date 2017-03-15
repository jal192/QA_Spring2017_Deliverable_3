/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 10
	Total number of tests: 30
	
	Requirements Tested: 4, 5
	
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
	private String fibUrl;
	
	private String homeExt = "";
	private String factExt = "fact";
	private String fibExt = "fib";
	private String helloExt = "hello";
	private String cathyExt = "cathy";
	
	
	// Start at the Fibonacci page for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		fibUrl = "https://cs1632ex.herokuapp.com/fib";
		driver.get(fibUrl);
	}
	
	
	// #######################################
	// ############# VALID INPUT #############
	// #######################################
	
	
	// Tests requirement #4
	// Tests explicit boundary value 1.
	
	// Given the Fibonacci page, enter and submit 1 for calulation.
	// Ensure that if the user enters a valid integer between 1 and 100, a message containing the correct results is displayed.
	@Test
	public void FibonacciValidInput1() throws Exception {
		// Clear the textbox then enter 1 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("1");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	
	// Tests requirement #4
	// Tests explicit boundary value 100.
	
	// Given the Fibonacci page, enter and submit 100 for calulation.
	// Ensure that if the user enters a valid integer between 1 and 100, a message containing the correct results is displayed.
	@Test
	public void FibonacciValidInput100() throws Exception {
		// Clear the textbox then enter 100 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("100");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 100 is 354224848179261915075!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #4
	
	// Given the Fibonacci page, enter and submit 30 for calulation.
	// Ensure that if the user enters a valid integer between 1 and 100, a message containing the correct results is displayed.
	@Test
	public void FibonacciValidInput30() throws Exception {
		// Clear the textbox then enter 30 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("30");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 30 is 832040!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #4
	
	// Given the Fibonacci page, enter and submit 50 for calulation.
	// Ensure that if the user enters a valid integer between 1 and 100, a message containing the correct results is displayed.
	@Test
	public void FibonacciValidInput50() throws Exception {
		// Clear the textbox then enter 50 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
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
	
	// Given the Fibonacci page, enter and submit 0 for calulation.
	// Ensure that if the user enters and submits an integer less than 1 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInput0() throws Exception {
		// Clear the textbox then enter 0 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("0");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 0 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}	
	
	
	// Tests requirement #5
	// Tests explicit boundary value 101.
	
	// Given the Fibonacci page, enter and submit 101 for calulation.
	// Ensure that if the user enters and submits an integer greater than 100 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInput101() throws Exception {
		// Clear the textbox then enter 100 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("101");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 101 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	
	// Tests requirement #5
	
	// Given the Fibonacci page, enter and submit -713 for calulation.
	// Ensure that if the user enters and submits an integer less than 1 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputLessThan1() throws Exception {
		// Clear the textbox then enter -713 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("-713");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of -713 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #5
	
	// Given the Fibonacci page, enter and submit 777 for calulation.
	// Ensure that if the user enters and submits an integer greater than 100 that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputGreaterThan100() throws Exception {
		// Clear the textbox then enter 777 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("777");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 777 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	
	// Tests requirement #5
	
	// Given the Fibonacci page, enter and submit 1.234567 for calulation.
	// Ensure that if the user enters a float number that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputFloat() throws Exception {
		// Clear the textbox then enter 1.234567 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("1.234567");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 1.234567 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #5
	
	// Given the Fibonacci page, enter and submit Party Time! for calulation.
	// Ensure that if the user enters a string/text that a message is presented 
	// to the user indicating that the Fibonacci of their input is 1.
	@Test
	public void FibonacciInvalidInputString() throws Exception {
		// Clear the textbox then enter Party Time! into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("Party Time!");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of Party Time! is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Clean up after each test, close browser window and end session
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}