package practice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static utils.MySystem.currentProjectDirectory;

public class Log4JTest {

    public static void main(String[] args) {

        System.setProperty("log4j.configurationFile", currentProjectDirectory() + "/src/test/resources/log4j2.xml");

        Logger log = LogManager.getLogger(Log4JTest.class.getName());



        // Write current class name to Log4J log file
        Class<? extends Object> thisClass = new Object() {}.getClass();
        String className = thisClass.getEnclosingClass().getSimpleName();
        log.info(className);


        // Write something to log file
        log.debug("Hello ");
        log.info("World");



    }

}
