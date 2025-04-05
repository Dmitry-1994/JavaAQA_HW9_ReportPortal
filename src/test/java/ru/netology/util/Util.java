package ru.netology.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Util {
    private static final Logger LOGGER = LogManager.getLogger(Util.class);

    public static void logInfo(String msg) {
        LOGGER.info(msg);
    }
}
