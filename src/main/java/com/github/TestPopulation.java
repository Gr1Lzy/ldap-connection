package com.github;

import com.github.service.LdapAddService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import java.util.Arrays;
import java.util.List;

import static com.github.attribute.AttributeEnum.ORGANIZATION;
import static com.github.attribute.AttributeEnum.ORGANIZATIONAL_UNIT;

public class TestPopulation {
    private static final String BASE_DN = "dc=example,dc=com";
    private static final String COMPANY = "Company";
    private static final String USERS = "users";
    private static final String DN_FORMAT = "%s=%s,%s";
    private final LdapAddService ldapAddService = new LdapAddService();
    private static final Logger logger = LoggerFactory.getLogger(TestPopulation.class);

    public void populate(DirContext context) throws NamingException {

        String companyDn = String.format(DN_FORMAT, ORGANIZATION.getKey(), COMPANY, BASE_DN);
        Attributes companyAttributes = ldapAddService.getOrganization(COMPANY);
        context.createSubcontext(companyDn, companyAttributes);
        logger.info("Created organization: {}", COMPANY);

        String usersDn = String.format(DN_FORMAT, ORGANIZATIONAL_UNIT.getKey(), USERS, companyDn);
        Attributes usersAttributes = ldapAddService.getOrganizationUnit(USERS);
        context.createSubcontext(usersDn, usersAttributes);
        logger.info("Created organizational unit: {}", USERS);

        List<String> organizationUnits = Arrays.asList("HR", "Engineering", "Programmers");

        for (String ou : organizationUnits) {
            String ouDn = String.format(DN_FORMAT, ORGANIZATIONAL_UNIT.getKey(), ou, usersDn);
            Attributes ouAttributes = ldapAddService.getOrganizationUnit(ou);
            context.createSubcontext(ouDn, ouAttributes);
            logger.info("Created organizational unit: {}", ou);

            for (int i = 1; i <= 3; i++) {
                String cn = String.format("Person%d", i);
                String sn = String.format("Surname%d", i);
                Attributes personAttributes = ldapAddService.getPerson(cn, sn);
                String personDn = String.format(DN_FORMAT, "cn", cn, ouDn);
                context.createSubcontext(personDn, personAttributes);
                logger.info("Created person: {} {}", cn, sn);
            }
        }

        context.close();
    }
}
