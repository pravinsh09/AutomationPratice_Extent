package com.Util;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getinstance() {

		if (extent == null) {
			extent = new ExtentReports(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\extent.html",
					true, DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(
					new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Config\\ReportsConfig.xml"));

		}
		return extent;
	}

}
