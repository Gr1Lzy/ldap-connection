package com.github.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(PropertyConfiguration.class);
    private static final String PROPERTIES_FILE = "ldap.properties";

    private PropertyConfiguration() {}

    public static Properties loadProps() {
        Properties properties = new Properties();

        try (InputStream input = PropertyConfiguration.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
            if (input == null) {
                logger.error("Unable to find {}", PROPERTIES_FILE);
                return properties;
            }
            properties.load(input);
        } catch (IOException e) {
            logger.error("Error loading properties file {}", PROPERTIES_FILE, e);
        }

        return properties;
    }
}
