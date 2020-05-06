package org.zalan;

import javax.swing.plaf.FileChooserUI;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMClass extends BaseClass {
	
	public POMClass() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='q']")
	private WebElement textInput;

	public WebElement getTextInput() {
		return textInput;
	}


}
