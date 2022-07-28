package org.testautomationgit.com;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestInitial {
	
	private WebDriver driver;
	//By findLocator = By.xpath("//body/div[1]/div[3]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
	//By findLocator = By.name("q");
	
	@Before
	public void setUp () {
		//revisar documentacion https://serenity-bdd.github.io/theserenitybook/latest/web-testing-in-serenity.html sección Configuring Drivers para identificar el WebDriver de acuerdo al navegador
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
		//creamos una nueva instancia del driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//abrimos URL
		driver.get("https://www.google.com");
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPage () {
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear();
		searchbox.sendKeys("Lista de paises de america");
		searchbox.sendKeys(Keys.ENTER);
		//searchbox.submit();
		driver.get("https://www.saberespractico.com/geografia/paises/paises-de-america/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> strong = driver.findElements(By.tagName("strong"));
		assertEquals("35 países", strong.get(2).getText());
	}
	
	@After
	public void tearDown () {
		driver.quit();
	}
}

