/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	TODO - ADD COMMENTS
		 - Organize Tests
		 - Name tests better
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

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	//
	@Test
	public void testHellovalid() throws Exception {
		driver.get(baseUrl + "/hello/Nyan Laboon Cat");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from Nyan Laboon Cat[\\s\\S]*$"));
	}

	//
	@Test
	public void testHellonothingadded() throws Exception {
		driver.findElement(By.linkText("Hello")).click();
		assertEquals("Hello CS1632, from Prof. Laboon!", driver.findElement(By.cssSelector("h2")).getText());
	}

	//
	@Test
	public void testHelloint() throws Exception {
		driver.get(baseUrl + "/hello/713");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from 713[\\s\\S]*$"));
	}

	//
	@Test
	public void testHellofloat() throws Exception {
		driver.get(baseUrl + "/hello/3.141592653");
		assertTrue(driver.findElement(By.cssSelector("h2")).getText().matches("^[\\s\\S]*Hello CS1632, from 3\\.141592653[\\s\\S]*$"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}