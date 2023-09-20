package Reportes;

import com.aventstack.extentreports.ExtentReports;
public class ExtentFactory {
    public static ExtentReports getInstance() {
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("Selenium Version", "4.11.0");
        extent.setSystemInfo("OS", "Mac OS X");
        extent.setSystemInfo("Navegador", "Chrome");
        extent.setSystemInfo("Ambiente", "QA");
        return extent;
    }
}