package utils;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utils.BaseClass.driver;

public class CommonMethods {

    public static Logger log = LogManager.getLogger(BaseClass.class.getName());


    /**
     * This method will take a screenshot
     *
     * @param fileName
     */
    public static byte[] takeScreenshot(String fileName) {

        TakesScreenshot ts = (TakesScreenshot) driver;

        byte[] picture = ts.getScreenshotAs(OutputType.BYTES);

        File file = ts.getScreenshotAs(OutputType.FILE);
        String screenshotFile = Constants.SCREENSHOTS_FILEPATH + fileName + timeStamp() + ".png";

        try {
            FileUtils.copyFile(file, new File(screenshotFile));
            log.info("Screenshot has taken file name  :  [" + screenshotFile + " ]");


        } catch (IOException e) {
            log.info("Cannot take a screenshot ", e);
        }

        return picture;
    }


    public static String timeStamp() {

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
        String timeStamp = sdf.format(date.getTime());

        return timeStamp;
    }


}
