/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 3
	Total number of tests: 31
	
	Requirements Tested: 1, 2
	
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

public class HomeTest {
	static WebDriver driver;
	private String baseUrl;
	
	private String homeExt = "";
	private String factExt = "fact";
	private String fibExt = "fib";
	private String helloExt = "hello";
	private String cathyExt = "cathy";
	
	
	// Start at the app homepage for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	
	// Tests requirement #1
	
	// Given the app homepage, ensure that the homepage has the correct welcome message displayed to the user.
	@Test
	public void HomeHasCorrectWelcomeMessage() throws Exception {
		assertTrue(driver.findElement(By.cssSelector("p.lead")).getText().matches("^[\\s\\S]*Welcome, friend,\nto a land of pure calculation[\\s\\S]*$"));
	}
	
	
	// Tests requirement #1
	
	// Given the app homepage, ensure that the homepage has the correct message indicating what the page is used for.
	@Test
	public void HomeHasCorrectPageUsedForMessage() throws Exception {
		assertEquals("Used for CS1632 Software Quality Assurance, taught by Bill Laboon", driver.findElement(By.cssSelector("div.row > p.lead")).getText());
	}
	
	
	// ##############################################
	// ############# CHECK HEADER LINKS #############
	// ##############################################
	
	
	// Tests requirement #2
	
	// Given the app homepage, ensure that the five links at the top match to the correct corresponding link.
	// This test checks all 5 links on the homepage in one test instead of 5 separate tests to prevent 
	// more than three assertions in one test and not go over the maximum of 30 tests.
	@Test
	public void HomeCheckHeaderLinks() {
		
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
			// Store the resulting URL in an arraylist then return back to the home page.
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
