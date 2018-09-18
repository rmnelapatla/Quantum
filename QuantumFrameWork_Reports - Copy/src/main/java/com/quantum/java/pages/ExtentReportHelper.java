package com.quantum.java.pages; /**
 * Created by s1196522 on 9/20/2017.
 */


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;

import java.io.File;
import java.io.IOException;
import java.util.Date;



public class ExtentReportHelper {

    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;
    static File ExtentFailStepScreenPath;



    public ExtentReportHelper(String sExtentReportDbServer, String sExtentReportDbServerPort, String sHtmlReportName,
                              String sProjectName, String sExtentReportServer, String sExtentReportServerPort,
                              String sExtentAutomationUser) throws Exception {

        KlovReporter klov = new KlovReporter();
        // specify mongoDb connection
        klov.initMongoDbConnection(sExtentReportDbServer, Integer.parseInt(sExtentReportDbServerPort));
        // specify project
        // ! you must specify a project, other a "Default project will be used"
        klov.setProjectName(sProjectName);

        Date date = new Date();
        // you must specify a reportName otherwise a default timestamp will be used
        klov.setReportName(sProjectName + "_" +  date.toString());

        // URL of the KLOV server
        // you must specify the server URL to ensure all your runtime media is uploaded
        // to the server
        klov.setKlovUrl("http://" + sExtentReportServer + ":" + sExtentReportServerPort);

        // initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(sHtmlReportName + ".html");
        // htmlReporter.loadXMLConfig("extent-config.xml"); //you can
        // attach only HtmlReporter
        extent.attachReporter(htmlReporter);
//                 attach all reporters
        extent.attachReporter(htmlReporter, klov);
        extent.setSystemInfo("User", sExtentAutomationUser);


    }

    public void CreateTest(String TestCaseName, String Description) {
        if (extent != null) {
            test = extent.createTest(TestCaseName, Description);
        }

    }

    public void StepPass(String Description) {
        if (test != null)
            test.pass("Pass - " + Description);

    }

    public void StepFail(String Description) throws IOException {

        if (ExtentFailStepScreenPath != null) {

            if (test != null)
                test.fail("Fail - " + Description, MediaEntityBuilder
                        .createScreenCaptureFromPath(ExtentFailStepScreenPath.getAbsolutePath()).build());
        } else if (test != null)
            test.fail("Fail - " + Description);

    }

    public void FlushReport() {
        if (extent != null)
            extent.flush();
    }

    public void AssignCategory(String category) {
        if (test != null)
            test.assignCategory(category);
    }

    public void AssignAuthor(String author) {
        if (test != null)
            test.assignAuthor(author);
    }
}
