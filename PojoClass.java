package org.movie;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PojoClass extends BaseClass {
	public PojoClass() {
		PageFactory.initElements(driver, this);
	}
	//IMDB
	@FindBy(xpath="//a[text()='December 17, 2021 (United States)']")
	private WebElement releaseDateInImdb;
	@FindBy(xpath="//a[text()='India']")
	private WebElement countryOfOriginInImdb;
	
	
	
	public WebElement getReleaseDateInImdb() {
		return releaseDateInImdb;
	}
	public WebElement getCountryOfOriginInImdb() {
		return countryOfOriginInImdb;
	}
	public WebElement getReleaseDateInWiki() {
		return releaseDateInWiki;
	}
	public WebElement getCountryInWiki() {
		return countryInWiki;
	}
	
	
	//Wiki
	
	@FindBy(xpath="//table/tbody/tr[12]/td//div//li")
	private WebElement releaseDateInWiki;
	@FindBy(xpath="//table/tbody/tr[14]/td[text()='India']")
	private WebElement countryInWiki;

}
