/*
	Jason Ly
	3/15/17
	cs1632
	Deliverable 3
	
	Number of tests: 1
	
	Requirements Tested: 2, 8
	
	Requirement #2 is implicitly tested by navigating to the factorial page from the app homepage.
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
	
	
	// Start at the app homepage for each test
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://cs1632ex.herokuapp.com/";
		driver.get(baseUrl);
	}
	
	// Tests requirement #8
	// This test implicitly tests requirement #2, ensuring that clicking on the 
	// Cathedral header link leads to pictures of the Cathedral of Learning.
	
	// This test ensures that there are only three items displayed to the user.
	@Test
	public void OnlyThreePictureElements() throws Exception {
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