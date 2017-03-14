/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 4
	Total number of tests: 28
	
	Requirements Tested: 2, 6, 7
	
	Requirement #2 is implicitly tested by navigating to the Hello page from the app homepage.
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
	
	
	// Tests requirement #6
	
	// Given the app homepage, navigate to the Hello page.
	// Ensure that if the user accesses the hello page with no trailing values in the URL that it
	// will display the default hello message from Laboon.
	@Test
	public void HelloNoTrailingValue() throws Exception {
		driver.findElement(By.linkText("Hello")).click();
		assertEquals("Hello CS1632, from Prof. Laboon!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	
	// Tests requirement #7
	
	// Given the app homepage, navigate to the Hello page with a trailing string/text value.
	// Ensure that if the user accesses the hello page with a trailing string in the URL that it
	// will display the hello message from the string/text input the user entered.
	@Test
	public void HelloTrailingString() throws Exception {
		driver.get(baseUrl + "/hello/Nyan Laboon Cat");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from Nyan Laboon Cat[\\s\\S]*$"));
	}

	
	// Tests requirement #7
	
	// Given the app homepage, navigate to the Hello page with a trailing integer value.
	// Ensure that if the user accesses the hello page with a trailing integer in the URL that it
	// will display the hello message from the integer input the user entered.
	@Test
	public void HelloTrailingInt() throws Exception {
		driver.get(baseUrl + "/hello/713");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from 713[\\s\\S]*$"));
	}

	
	// Tests requirement #7
	
	// Given the app homepage, navigate to the Hello page with a trailing float value.
	// Ensure that if the user accesses the hello page with a trailing float in the URL that it
	// will display the hello message from the float input the user entered.
	@Test
	public void HelloTrailingFloat() throws Exception {
		driver.get(baseUrl + "/hello/3.141592653");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from 3\\.141592653[\\s\\S]*$"));
	}
	
	
	// Clean up after each test, close browser window and end session
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}