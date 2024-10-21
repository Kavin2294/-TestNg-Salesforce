package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class CreateOpportunity extends BaseClass {
	
		public void CreateOpp() {

			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
			driver.findElement(By.xpath("//p[text()='Sales']")).click();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement clickOpportunity = driver.findElement(By.xpath("//span[text()='Opportunities']"));
			js.executeScript("arguments[0].click();", clickOpportunity);
			driver.findElement(By.xpath("//div[text()='New']")).click();
			driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Salesforce Automation by Kavin");
			driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys("75000");
			driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
			driver.findElement(By.xpath("//button[text()='Today']")).click();
			driver.findElement(By.xpath("(//button[contains(@class,'slds-combobox__input')])[2]")).click();
			driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		    driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		    WebElement OppName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']"));
		    String OpportunityName = OppName.getText();
		    System.out.println(OpportunityName);
		    
		    String ExpectingText = "Salesforce Automation by Kavin";
		    
		    Assert.assertEquals(OpportunityName, ExpectingText);
		    System.out.println("The opportunity Name is Verified");
		    driver.close();
		}

	}



