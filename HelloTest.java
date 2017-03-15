/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 5
	Total number of tests: 31
	
	Requirements Tested: 2, 6, 7
	
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

public class HelloTest {
	static WebDriver driver;
	private String baseUrl = "https://cs1632ex.herokuapp.com/";
	
	private String homeExt = "";
	private String factExt = "fact";
	private String fibExt = "fib";
	private String helloExt = "hello";
	private String cathyExt = "cathy";
	
	
	// Start at the hello page for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		helloUrl = "https://cs1632ex.herokuapp.com/hello";
		driver.get(helloUrl);
	}
	
	
	// #######################################
	// ############# VALID INPUT #############
	// #######################################
	
	
	// Tests requirement #6
	
	// Given the hello page, don't add any trailing value to the end of the url.
	// Ensure that if the user accesses the hello page with no trailing values in the URL that it
	// will display the default hello message from Laboon.
	@Test
	public void HelloNoTrailingValue() throws Exception {
		assertEquals("Hello CS1632, from Prof. Laboon!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #7
	
	// Given the hello page, add a trailing string/text value that consists of letters and special characters to the end of the starting URL.
	// Ensure that if the user accesses the hello page with a trailing string in the URL that it
	// will display the hello message from the string/text input the user entered.
	@Test
	public void HelloTrailingString() throws Exception {
		driver.get(baseUrl + "/Nyan Laboon Cat ! @ # $ % ^ & * ( )");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from Nyan Laboon Cat ! @ # \\$ % ^ & [\\s\\S]* \\( \\)[\\s\\S]*$"));
	}

	
	// Tests requirement #7
	
	// Given the hello page, add a trailing integer value to the end of the starting URL.
	// Ensure that if the user accesses the hello page with a trailing integer in the URL that it
	// will display the hello message from the integer input the user entered.
	@Test
	public void HelloTrailingInt() throws Exception {
		driver.get(baseUrl + "/713");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from 713[\\s\\S]*$"));
	}

	
	// Tests requirement #7
	
	// Given the hello page, add a trailing float value to the end of the starting URL.
	// Ensure that if the user accesses the hello page with a trailing float in the URL that it
	// will display the hello message from the float input the user entered.
	@Test
	public void HelloTrailingFloat() throws Exception {
		driver.get(baseUrl + "/3.141592653");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from 3\\.141592653[\\s\\S]*$"));
	}
	
	
	// ##############################################
	// ############# CHECK HEADER LINKS #############
	// ##############################################
	
	
	// Tests requirement #2
	
	// Given the hello page, ensure that the five links at the top match to the correct corresponding link.
	// This test checks all 5 links on the hello page in one test instead of 5 separate tests to prevent 
	// more than three assertions in one test and not go over the maximum of 30 tests.
	@Test
	public void HelloCheckHeaderLinks() {
		
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
			// Store the resulting URL in an arraylist then return back to the hello page.
			// If any of the header links cannot be opened then the test fails.
			driver.findElement(By.linkText("CS1632 D3 Home")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(baseUrl);
			
			driver.findElement(By.linkText("Factorial")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(baseUrl);
			
			driver.findElement(By.linkText("Fibonacci")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(baseUrl);
			
			driver.findElement(By.linkText("Hello")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(baseUrl);
			
			driver.findElement(By.linkText("Cathedral Pics")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(baseUrl);
			
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