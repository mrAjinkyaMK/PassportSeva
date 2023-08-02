package com.UtilsLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.BaseLaye.BaseClass;

public class handelingActions extends BaseClass {

	public static void mouseClick(WebElement wb) {
		Actions act = new Actions(driver);
		act.click(wb).build().perform();
	}

	public static void mouseDoubleClick(WebElement wb) {
		Actions act = new Actions(driver);
		act.doubleClick(wb).build().perform();
	}

	public static void mouseRightClick(WebElement wb) {
		Actions act = new Actions(driver);
		act.contextClick(wb).build().perform();
	}

	public static void mouseOver(WebElement wb) {
		Actions act = new Actions(driver);
		act.moveToElement(wb).build().perform();
	}

	public static void dragAndDrop(WebElement wb_src, WebElement wb_dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(wb_src, wb_dest);
	}
	
	public static void dragAndHold(WebElement wb) {
		Actions act = new Actions(driver);
		act.clickAndHold(wb).build().perform();
	}
	
	public static void release(WebElement wb) {
		Actions act = new Actions(driver);
		act.release(wb).build().perform();
	}
	
	public static void sendKeys(WebElement wb,String value) {
		Actions act = new Actions(driver);
		act.sendKeys(wb, value).build().perform();
	}
	
}













