/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	TODO - ADD COMMENTS
		 - Organize Tests
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
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	//
	@Test
	public void testFact0() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("0");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 0 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	//
	@Test
	public void testFact1() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("1");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 1 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	//
	@Test
	public void testFact73() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("73");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 73 is 4470115461512684340891257138125051110076800700282905015819080092370422104067183317016903680000000000000000!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	//
	@Test
	public void testFact100() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("100");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 100 is 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000!", driver.findElement(By.cssSelector("h2")).getText());
	}
  
	//
	@Test
	public void testFact101() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("101");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 101 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	//
	@Test
	public void testFact713() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("-713");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of -713 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
	
	//
	@Test
	public void testFactfloat() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("3.141592653");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of 3.141592653 is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
  
	//
	@Test
	public void testFactstring() throws Exception {
		driver.findElement(By.linkText("Factorial")).click();
		driver.findElement(By.name("value")).clear();
		driver.findElement(By.name("value")).sendKeys("Nyan Laboon Cat");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		assertEquals("Factorial of Nyan Laboon Cat is 1!", driver.findElement(By.cssSelector("h2")).getText());
	}
  
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
