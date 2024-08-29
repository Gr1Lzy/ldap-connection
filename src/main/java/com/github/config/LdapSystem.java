package com.github.config;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;
import java.util.Properties;

public class LdapSystem {
    private LdapSystem() {}

    public static InitialDirContext setup() throws NamingException {
        Properties properties = PropertyConfiguration.loadProps();
        Hashtable<String, String> environment = new Hashtable<>();

        environment.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        environment.put(Context.PROVIDER_URL, properties.getProperty("ldap.url"));
        environment.put(Context.SECURITY_PRINCIPAL, properties.getProperty("ldap.bind.dn"));
        environment.put(Context.SECURITY_CREDENTIALS, properties.getProperty("ldap.bind.password"));

        return new InitialDirContext(environment);
    }
}
