package com.github;

import com.github.config.LdapSystem;
import com.github.service.LdapAddService;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;

public class Main {
    public static void main(String[] args) throws NamingException {
        DirContext context = LdapSystem.setup();
        LdapAddService ldapAddService = new LdapAddService();

        String dn = "o=Company,dc=example,dc=com";


        Attributes attributes = ldapAddService.getOrganization("Company");
        context.destroySubcontext(dn);
        context.close();
    }
}
