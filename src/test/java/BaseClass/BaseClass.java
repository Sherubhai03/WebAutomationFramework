package BaseClass;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"OS","browser"})
	public void setup(String OS, String br) throws IOException {
		logger=LogManager.getLogger(this.getClass());
		
		//Load property file
		FileReader fd = new FileReader("./src/test/resources/config.properties");
		p=new Properties();
		p.load(fd);
		
		switch (br.toLowerCase()) {
		case "chrome" : driver=new ChromeDriver(); break;
		case "edge" : driver=new EdgeDriver(); break;
		default : System.out.println("Invald Browser"); return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		logger.info(".....Browser Invoked......");
		driver.get(p.getProperty("acURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String randomString() {
		String genRanChar = RandomStringUtils.randomAlphabetic(5);
		return genRanChar;	
	}
	public String randomNumber() {
		String genRanNo = RandomStringUtils.randomNumeric(10);
		return genRanNo;	
	}
	public String randomAlphaNumber() {
		String genRanChar = RandomStringUtils.randomAlphabetic(3);
		String genRanNo = RandomStringUtils.randomNumeric(7);
		return (genRanChar+"@"+genRanNo);	
	}
}
