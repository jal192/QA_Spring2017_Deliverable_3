/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	TODO - ADD COMMENTS
		 - Organize Tests
		 - Make better test names
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

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	//
	@Test
	public void testFib0() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("0");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 0 is 0!", driver.findElement(By.cssSelector("h2")).getText());
	}	

	//
	@Test
	public void testFib1() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("1");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	//
	@Test
	public void testFib100() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("100");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 100 is 354224848179261915075!", driver.findElement(By.cssSelector("h2")).getText());
	}

	//
	@Test
	public void testFibfloat() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("1.234567");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 1.234567 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	//
	@Test
	public void testFibneg() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("-713");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of -713 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}

	//
	@Test
	public void testFibreg() throws Exception {
		driver.findElement(By.linkText("Fibonacci")).click();
		driver.findElement(By.id("tb1")).clear();
		driver.findElement(By.id("tb1")).sendKeys("30");
		driver.findElement(By.id("sub")).click();
		assertEquals("Fibonacci of 30 is 832040!", driver.findElement(By.cssSelector("h2")).getText());
	}

	//
	@Test
	public void testFibstring() throws Exception {
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