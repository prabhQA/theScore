package com.tests;

import java.net.MalformedURLException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.driver.Driver;
import com.pages.League_Pages;
import com.pages.Score_pages;
import com.utilities.ReadPropertiesFile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ScoreTest extends Driver {
	AndroidDriver<AndroidElement> driver;
	public static final String fileName = null;
	public ReadPropertiesFile readfile = new ReadPropertiesFile();
	public Properties prop = readfile.readPropertiesFile(fileName);
	public Score_pages score_pages = new Score_pages();
	public League_Pages league_pages = new League_Pages();

	@BeforeClass
	public void initialization() throws MalformedURLException {
		Driver.capabilities();
	}

	@Test
	public void getStarted_NavigatingToLeagues() {
		score_pages.waitForApptoLoad();
		score_pages.getStarted_Click();
		score_pages.sportSelection();
		score_pages.continue_Button();
		score_pages.mayBeLater_button();
		score_pages.favTeamSelection();
		score_pages.continue_Button();
		score_pages.Done_button();
		Assert.assertEquals(league_pages.getNFLText(), "NFL");
	}

	@Test
	public void navigatingToLeaguesection() {
		league_pages.navtoLeagueSection();
		//Assert.assertEquals(league_pages.verifySelected_League(), "NFL FOOTBALL");
		league_pages.navTo_Standing_Tab();
		Assert.assertEquals(league_pages.verifySelected_SubTab(), "AFC");
	}

	@Test
	public void nav_back() {
		league_pages.back_button_arrow();
		Assert.assertEquals(league_pages.getNFLText(), "NFL");
	}

	@AfterClass
	public void quit() {
		System.out.println("Quit");
	}
}
