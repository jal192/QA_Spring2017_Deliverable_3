/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 2
	Total number of tests: 30
	
	Requirements Tested: 2, 8
	
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

public class CathedralPicsTest {
	static WebDriver driver;
	private String baseUrl = "https://cs1632ex.herokuapp.com/";
	private String cathyUrl;
	
	private String homeExt = "";
	private String factExt = "fact";
	private String fibExt = "fib";
	private String helloExt = "hello";
	private String cathyExt = "cathy";
	
	// Start at the Cathedral pictures page for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		cathyUrl = "https://cs1632ex.herokuapp.com/cathy";
		driver.get(cathyUrl);
	}
	
	
	// Tests requirement #8
	
	// This test ensures that there are only three items displayed to the user.
	@Test
	public void CathedralPicsOnlyThreePictureElements() throws Exception {
		// Count the number of elements in the list.
		// Check to ensure that there is only three elements.
		List<WebElement> ol = driver.findElements(By.xpath("//ol"));
		List<WebElement> picCount = ol.get(0).findElements(By.tagName("li"));
		assertEquals(3, picCount.size());
	}
	
	
	// ##############################################
	// ############# CHECK HEADER LINKS #############
	// ##############################################
	
	
	// Tests requirement #2
	
	// Given the Cathedral Pictures page, ensure that the five links at the top match to the correct corresponding link.
	// This test checks all 5 links on the Cathedral Pictures page in one test instead of 5 separate tests to prevent 
	// more than three assertions in one test and not go over the maximum of 30 tests.
	@Test
	public void CathedralPicsCheckHeaderLinks() {
		
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
			// Store the resulting URL in an arraylist then return back to the Cathedral Pictures page.
			// If any of the header links cannot be opened then the test fails.
			driver.findElement(By.linkText("CS1632 D3 Home")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(cathyUrl);
			
			driver.findElement(By.linkText("Factorial")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(cathyUrl);
			
			driver.findElement(By.linkText("Fibonacci")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(cathyUrl);
			
			driver.findElement(By.linkText("Hello")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(cathyUrl);
			
			driver.findElement(By.linkText("Cathedral Pics")).click();
			resultedURL.add(driver.getCurrentUrl());
			driver.get(cathyUrl);
			
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