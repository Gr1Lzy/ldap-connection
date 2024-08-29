package com.github.service;

import javax.naming.NamingException;
import javax.naming.directory.*;

public class LdapAddService {
    public void addOrganization(DirContext context) throws NamingException {
        String organizationDN = "o=Company,dc=example,dc=com";
        Attributes attributes = new BasicAttributes(true);
        Attribute attribute = new BasicAttribute("objectClass");
        attribute.add("top");
        attribute.add("organization");
        attributes.put(attribute);
        attributes.put("o", "Company");

        context.createSubcontext(organizationDN, attributes);
        System.out.println("Added organization: " + organizationDN);
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
        System.out.println("Added organizational unit: " + organizationalUnitDN);
    }
}
