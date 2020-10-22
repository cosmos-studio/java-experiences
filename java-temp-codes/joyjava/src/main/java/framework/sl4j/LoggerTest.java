package framework.sl4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    public static void main(String[] args) {
        Logger LOG = LoggerFactory.getLogger(LoggerTest.class);
        Exception e = new Exception("one Exception");
        LOG.debug("Debug -> ");
        LOG.info("Info -> ");
        LOG.warn("Warn -> ");
        LOG.error("Error -> ");
    }
}
