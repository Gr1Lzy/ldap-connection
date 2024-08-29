package com.github;

import com.github.config.LdapSystem;
import com.github.service.LdapAddService;

import javax.naming.NamingException;
import javax.naming.directory.*;

public class Main {
    public static void main(String[] args) {
        LdapAddService ldapAddService = new LdapAddService();

        try {
            InitialDirContext context = LdapSystem.setup();
            System.out.println("Connected to LDAP server successfully.");

            ldapAddService.addOrganization(context);
            ldapAddService.addOrganizationalUnit(context);

            context.close();
        } catch (NamingException e) {
            System.out.println("Failed to connect to LDAP server or add entries.");
            e.printStackTrace();
        }
    }


}
