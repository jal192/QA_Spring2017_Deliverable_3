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

public class CathedralPicsTest {
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
	public void testCath() throws Exception {
		driver.findElement(By.linkText("Cathedral Pics")).click();
		List<WebElement> ol = driver.findElements(By.xpath("//ol"));
	List<WebElement> picCount = ol.get(0).findElements(By.tagName("li"));
		assertEquals(3, picCount.size());
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}