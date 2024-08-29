package com.github.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingException;
import javax.naming.directory.*;

public class LdapAddService {
    private static final Logger logger = LoggerFactory.getLogger(LdapAddService.class);

    public void addOrganization(DirContext context, String o) throws NamingException {
        String organizationDN = String.format("o=%s,dc=example,dc=com", o);
        Attributes attributes = new BasicAttributes(true);
        Attribute attribute = new BasicAttribute("objectClass");
        attribute.add("top");
        attribute.add("organization");

        attributes.put(attribute);
        attributes.put("o", o);

        context.createSubcontext(organizationDN, attributes);

        logger.info("Added organization: {}", organizationDN);
    }

    public void addOrganizationalUnit(DirContext context) throws NamingException {
        String organizationalUnitDN = "ou=users,o=Company,dc=example,dc=com";
        Attributes attributes = new BasicAttributes(true);
        Attribute attribute = new BasicAttribute("objectClass");
        attribute.add("top");
        attribute.add("organizationalUnit");

        attributes.put(attribute);
        attributes.put("ou", "users");

        context.createSubcontext(organizationalUnitDN, attributes);

        logger.info("Added organizational unit: {}", organizationalUnitDN);
    }
}
