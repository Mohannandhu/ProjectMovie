package org.movie;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestngConcept extends BaseClass {
	@BeforeClass
	private void launchbrowser() {
		launchChrome();
		getUrl("https://www.imdb.com/title/tt9389998/");
		winMax();
	}

	@Test
	private void verifyReleaseDateAndCountrySameOrNotInImdbAndWiki() {

		//Fetching ReleaseDate And Country From IMDB

		PojoClass p = new PojoClass();
		moveapageUpDown(false, p.getReleaseDateInImdb());
		String imdbReleaseDate = p.getReleaseDateInImdb().getText();
		System.out.println("IMDB ReleaseDate :" + " " + imdbReleaseDate);
		String imdbCountry = p.getCountryOfOriginInImdb().getText();
		System.out.println("IMDB Country :" + " " + imdbCountry);

		//Fetching ReleaseDate And Country From Wiki
		
		implicityWait(5);
		navigateNextUrl("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		String wikiReleaseDate = p.getReleaseDateInWiki().getText();
		System.out.println("Wiki ReleaseDate :" + " " + wikiReleaseDate);
		String wikiCountry = p.getCountryInWiki().getText();
		System.out.println("Wiki Country :" + " " + wikiCountry);
		
		
		// Verify Both Are Same or Not

		SoftAssert s = new SoftAssert();
		s.assertTrue(wikiReleaseDate.equals(imdbReleaseDate), "Verify Release Date");
		s.assertTrue(wikiCountry.equals(imdbCountry), "Verify Country");
		s.assertAll();
		System.out.println("Date And Country Presented in IMDB & Wiki are Same For Pushpa Movie");

	}

	@AfterClass
	private void quitChrome() {
		browserQuit();

	}

}
