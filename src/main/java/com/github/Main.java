package com.github;

import com.github.config.LdapSystem;
import com.github.service.LdapAddService;
import com.github.service.LdapSearchService;
import com.github.service.LdapUpdateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.SearchControls;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        DirContext context;
        try {
            context = LdapSystem.setup();
            LdapAddService ldapAddService = new LdapAddService();
            LdapSearchService ldapSearchService = new LdapSearchService(context);
            LdapUpdateService ldapUpdateService = new LdapUpdateService(context);

            TestPopulation testPopulation = new TestPopulation();

            String companyDn = "dc=example,dc=com";
            String filter = "(objectClass=*)";
            String filterSearchUsers = "(ou=*)";
            String filterPerson = "(&(objectClass=*)(cn=Person1))";

            //testPopulation.populate(context);

            //ldapSearchService.search(companyDn, filterPerson, SearchControls.SUBTREE_SCOPE);

            String userDn = "cn=Person1,ou=HR,ou=users,o=Company,dc=example,dc=com";
            //ldapUpdateService.update(userDn, new BasicAttribute("sn", "NewSurname"));


            context.destroySubcontext(userDn);

            String newUserDn = "cn=newPerson,ou=HR,ou=users,o=Company,dc=example,dc=com";
            Attributes personAttributes = ldapAddService.getPerson("newPerson", "newPerson");
            context.createSubcontext(newUserDn, personAttributes);



            context.close();
        } catch (NamingException e) {
            logger.warn("ERROR:", e);
        }
    }
}
