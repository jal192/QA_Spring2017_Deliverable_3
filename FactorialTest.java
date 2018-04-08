/*
	Jason Ly
	3/15/17
	Deliverable 3
	
	Number of tests: 10
	Total number of tests: 30
	
	Requirements Tested: 2, 3, 5
	
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

public class FactorialTest {
	static WebDriver driver;
	private String baseUrl = "https://cs1632ex.herokuapp.com/";
	private String factUrl;
	
	private String homeExt = "";
	private String factExt = "fact";
	private String fibExt = "fib";
	private String helloExt = "hello";
	private String cathyExt = "cathy";
	

	// Start at the factorial page for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		factUrl = "https://cs1632ex.herokuapp.com/fact";
		driver.get(factUrl);
	}
	
	
	// #######################################
	// ############# VALID INPUT #############
	// #######################################
	
	
	// Tests requirement #3
	// Tests explicit boundary value 1.
	
	// Given the Factorial page, enter and submit 1 for calulation.
	// Ensure that if the user enters a valid integer between 1 and 100, a message containing the correct results is displayed.
	@Test
	public void FactorialValidInput1() throws Exception {
		// Clear the textbox then enter 1 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("1");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #3
	// Tests explicit boundary value 100.
	
	// Given the Factorial page, enter and submit 100 for calulation.
	// Ensure that if the user enters a valid integer between 1 and 100, a message containing the correct results is displayed.
	@Test
	public void FactorialValidInput100() throws Exception {
		// Clear the textbox then enter 100 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("100");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #3
	
	// Given the Factorial page, enter and submit 73 for calulation.
	// Ensure that if the user enters a valid integer between 1 and 100, a message containing the correct results is displayed.
	@Test
	public void FactorialValidInput73() throws Exception {
		// Clear the textbox then enter 73 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("73");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 73 is 4470115461512684340891257138125051110076800700282905015819080092370422104067183317016903680000000000000000!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// #########################################
	// ############# INVALID INPUT #############
	// #########################################
	
	
	// Tests requirement #5
	// Tests explicit boundary value 0.
	
	// Given the Factorial page, enter and submit 0 for calulation.
	// Ensure that if the user enters an integer less than 1 that a message is presented 
	// to the user indicating that the factorial of their input is 1.
	@Test
	public void FactorialInvalidInput0() throws Exception {
		// Clear the textbox then enter 0 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("0");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 0 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
  
	// Tests requirement #5
	// Tests explicit boundary value 101.
	
	// Given the Factorial page, enter and submit 101 for calulation.
	// Ensure that if the user enters an integer greater than 100 that a message is presented 
	// to the user indicating that the factorial of their input is 1.
	@Test
	public void FactorialInvalidInput101() throws Exception {
		// Clear the textbox then enter 101 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("101");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 101 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #5
	
	// Given the Factorial page, enter and submit 777 for calulation.
	// Ensure that if the user enters an integer greater than 100 that a message is presented 
	// to the user indicating that the factorial of their input is 1.
	@Test
	public void FactorialInvalidInputGreaterThan100() throws Exception {
		// Clear the textbox then enter 777 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("777");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 777 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #5
	
	// Given the Factorial page, enter and submit -713 for calulation.
	// Ensure that if the user enters an integer less than 1 that a message is presented 
	// to the user indicating that the factorial of their input is 1.
	@Test
	public void FactorialInvalidInputLessThan1() throws Exception {
		// Clear the textbox then enter -713 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("-713");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of -713 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #5
	
	// Given the Factorial page, enter and submit 3.141592653 for calulation.
	// Ensure that if the user enters a float number that a message is presented 
	// to the user indicating that the factorial of their input is 1.
	@Test
	public void FactorialInvalidInputFloat() throws Exception {
		// Clear the textbox then enter 3.141592653 into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("3.141592653");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 3.141592653 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
  
  
	// Tests requirement #5
	
	// Given the Factorial page, enter and submit Nyan Laboon Cat for calulation.
	// Ensure that if the user enters a string/text that a message is presented 
	// to the user indicating that the factorial of their input is 1.
	@Test
	public void FactorialInvalidInputString() throws Exception {
		// Clear the textbox then enter Nyan Laboon Cat into the textbox and submit the input to be calculated.
		// Ensure that the outputted message matches what is expected.
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("Nyan Laboon Cat");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of Nyan Laboon Cat is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// ##############################################
	// ############# CHECK HEADER LINKS #############
	// ##############################################
	
	
	// Tests requirement #2
	
	// Given the Factorial page, ensure that the five links at the top match to the correct corresponding link.
	// This test checks all 5 links on the Factorial page in one test instead of 5 separate tests to prevent 
	// more than three assertions in one test and not go over the maximum of 30 tests.
	@Test
	public void FactorialCheckHeaderLinks() {
		
		// Add all the expected Url to the arraylist
		ArrayList<String> expectedURL = new ArrayList<String>();
		expectedURL.add(baseUrl + homeExt);
		expectedURL.add(baseUrl + factExt);
		expectedURL.add(baseUrl + fibExt);
		expectedURL.add(baseUrl + helloExt);
		expectedURL.add(baseUrl + cathyExt);
		
		ArrayList<String> resultedURL = new ArrayList<String>();
		
		try { 
			// For each header link, click on the link and then retrieve the resulting URL.
			// Store the resulting URL in an arraylist then return back to the factorial page.
			// If any of the header links cannot be opened then the test fails.
			driver.findElement(By.linkText("CS1632 D3 Home")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(factUrl);
			
			driver.findElement(By.linkText("Factorial")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(factUrl);
			
			driver.findElement(By.linkText("Fibonacci")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(factUrl);
			
			driver.findElement(By.linkText("Hello")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(factUrl);
			
			driver.findElement(By.linkText("Cathedral Pics")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(factUrl);
			
		} catch (org.openqa.selenium.NotFoundException e) {
			fail();
		}
		
		assertEquals(expectedURL, resultedURL);
	}
  
	
	// Clean up after each test, close browser window and end session
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
