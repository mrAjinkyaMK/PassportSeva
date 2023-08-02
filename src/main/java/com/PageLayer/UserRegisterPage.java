package com.PageLayer;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseLaye.BaseClass;
import static com.UtilsLayer.UtilsClass.*;
import static com.UtilsLayer.HandleDropdown.*;

public class UserRegisterPage extends BaseClass {

//	locate webElements by using @FindBy
//	delcare webelements private global
//	initialize constructor
//	create associated methods of web elements

//	@FindBy(xpath = "//input[@name='cpvLocation']")
	@FindBy(xpath="//input[@name='cpvLocation']/following::label[contains(@for,'cpvLocation')]")
	private List<WebElement> applyAt;

	@FindBy(name = "dcdrLocation")
	private WebElement passportOffice;

	@FindBy(name = "givenName")
	private WebElement givenName;

	@FindBy(name = "surname")
	private WebElement surname;

	@FindBy(xpath = "//img[@class='ui-datepicker-trigger']")
	private WebElement calender;

	@FindBy(xpath = "//select[@class='ui-datepicker-month']")
	private WebElement month;

	@FindBy(xpath = "//select[@class='ui-datepicker-year']")
	private WebElement year;

	@FindBy(xpath = "//td[@data-handler='selectDay']")
	private List<WebElement> days;

	@FindBy(name = "email")
	private WebElement email;

	@FindBy(xpath = "//input[@name='emailloginSame']")
	private List<WebElement> logInWithEmail;

	@FindBy(name = "loginId")
	private WebElement loginId;

	@FindBy(name = "pwd")
	private WebElement password;

	@FindBy(name = "confirmPwd")
	private WebElement confirmPwd;

	@FindBy(name = "hintQues")
	private WebElement hintQues;

	@FindBy(name = "hintAns")
	private WebElement hintAns;

	public UserRegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void registerPageFunctionlity(String arg_applyAt, String city, String arg_givenName, String arg_surname,
			String arg_year, String arg_month, String arg_day, String arg_email, String arg_logInWithEmail,
			String arg_loginId, String arg_password, String cPassword, String hintQue, String arg_hindAns) {

		findElements(applyAt, arg_applyAt);
//		handleRegisterApplyRadioBtn(applyAt, arg_applyAt);
		if (arg_applyAt.equalsIgnoreCase("Passport Office")) {
			selectByVisibleText(passportOffice, city);
		}

		sendKeys(givenName, arg_givenName);
		sendKeys(surname, arg_surname);
		click(calender);
		selectByVisibleText(year, arg_year);
		selectByVisibleText(month, arg_month);
		findElements(days, arg_day);
		sendKeys(email, arg_email);
		findRadioElements(logInWithEmail, arg_logInWithEmail);
		sendKeys(loginId, arg_loginId);
		sendKeys(password, arg_password);
		sendKeys(confirmPwd, cPassword);
		selectByVisibleText(hintQues, hintQue);
		sendKeys(hintAns, arg_hindAns);

	}

}
