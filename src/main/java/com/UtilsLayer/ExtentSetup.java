package com.UtilsLayer;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.BaseLaye.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentSetup extends BaseClass {

	public static ExtentReports setUp(String reportName) {
		String path = System.getProperty("user.dir") + "//ExtentReport//" + reportName + date() + ".html";

		ExtentSparkReporter extentSpark = new ExtentSparkReporter(path);

		ExtentReports extentReports = new ExtentReports();

		extentReports.attachReporter(extentSpark);

		return extentReports;

	}

	public static String date() {

		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
	}

	public static String takeScreenshot(String folderName, String screenshotName) throws IOException {

		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//" + folderName + "//" + screenshotName + date() + ".png";

		FileUtils.copyFile(file, new File(path));
		return path;
	}

}
