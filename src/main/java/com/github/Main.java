package com.github;

import com.github.config.LdapSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DirContext context;
        try {
            context = LdapSystem.setup();

            TestPopulation testPopulation = new TestPopulation();
            testPopulation.populate(context);
        } catch (NamingException e) {
            logger.warn("ERROR:", e);
        }
    }
}
