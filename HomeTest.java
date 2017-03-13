/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	TODO - ADD COMMENTS
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

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	//
	@Test
	public void testHasCorrectHeaderLinks() throws Exception {
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
	
	//
	@Test
	public void testHasCorrectWelcomeMessage() throws Exception {
		assertTrue(driver.findElement(By.cssSelector("p.lead")).getText().matches("^[\\s\\S]*Welcome, friend,\nto a land of pure calculation[\\s\\S]*$"));
	}
	
	//
	@Test
	public void testHasCorrectPageUsedForMessage() throws Exception {
		assertEquals("Used for CS1632 Software Quality Assurance, taught by Bill Laboon", driver.findElement(By.cssSelector("div.row > p.lead")).getText());
	}
	
	//
	@Test
	public void testSeeHomeLink() {
		driver.findElement(By.linkText("CS1632 D3 Home")).click();
		String newPageTitle = driver.getTitle();
		assertTrue(newPageTitle.contains("CS1632 D3"));
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
