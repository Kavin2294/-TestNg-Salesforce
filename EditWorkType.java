package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class EditWorkType extends BaseClass  {
	
	@Test
	public void EditW() throws InterruptedException {
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("(//button[@class='slds-button'])[2]")).click();
		WebElement clickWorkType = driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", clickWorkType);
		driver.findElement(By.xpath("//input[@name='WorkTypeGroup-search-input']"))
				.sendKeys("Salesforce Automation by Kavin", Keys.ENTER);
		Thread.sleep(3000);
		WebElement clickDropDown = driver
				.findElement(By.xpath("//span[@class='slds-icon_container slds-icon-utility-down']"));
		js.executeScript("arguments[0].click();", clickDropDown);
		driver.findElement(By.xpath("//li[@class='uiMenuItem']//a")).click();
		WebElement description = driver.findElement(By.xpath("//textarea[@class='slds-textarea']"));
		description.clear();
		description.sendKeys("Automation");

		driver.findElement(By.xpath(
				"//button[@class='slds-combobox__input slds-input_faux fix-slds-input_faux slds-combobox__input-value']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Capacity']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Salesforce Automation by Kavin']")).click();
		String verDescription = driver.findElement(By.xpath("//lightning-formatted-text[text()='Automation']"))
				.getText();
		if (verDescription.equals("Automation")) {
			System.out.println("Description is Automation");
		} else {
			System.out.println("Description is not Automation");
		}
	}

}

	


