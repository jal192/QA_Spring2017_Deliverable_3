/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 4
	Total number of tests: 28
	
	Requirements Tested: 1, 2
	
	Requirement #2 is implicitly tested by navigating to the Homepage page from the app homepage.
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

	
	// Start at the app homepage for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	
	// Tests requirement #2
	
	// Given the app homepage, ensure that the homepage has five links on the page.
	@Test
	public void HomeHasCorrectHeaderLinks() throws Exception {
		try {
			driver.findElement(By.linkText("CS1632 D3 Home"));
			driver.findElement(By.linkText("Factorial"));
			driver.findElement(By.linkText("Fibonacci"));
			driver.findElement(By.linkText("Hello"));
			driver.findElement(By.linkText("Cathedral Pics"));
		} catch (org.openqa.selenium.NoSuchElementException nseex) {
			fail();
		}
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
	
	
	// Tests requirement #2
	
	// Given the app homepage, ensure that if the user tries to navigate from the homepage to home using
	// the "CS1632 D3 Home" link that it will take them to the homepage.
	@Test
	public void HomepageSeeHomeLink() {
		driver.findElement(By.linkText("CS1632 D3 Home")).click();
		String newPageTitle = driver.getTitle();
		assertTrue(newPageTitle.contains("CS1632 D3"));
	}
	
	
	// Clean up after each test, close browser window and end session
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
