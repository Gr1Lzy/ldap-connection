package com.github;

import com.github.config.LdapSystem;
import com.github.service.LdapSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DirContext context;
        try {
            context = LdapSystem.setup();

            TestPopulation testPopulation = new TestPopulation();
//            testPopulation.populate(context);

            String companyDn = "dc=example,dc=com";
            String filter = "(objectClass=*)";
            String filterSearchUsers = "(ou=HR)";
            String filterPerson = "(&(objectClass=*)(sn=Surname1))";

            LdapSearchService ldapSearchService = new LdapSearchService(context);

            ldapSearchService.search(companyDn, filterSearchUsers, SearchControls.SUBTREE_SCOPE);

            context.close();
        } catch (NamingException e) {
            logger.warn("ERROR:", e);
        }
    }
}
