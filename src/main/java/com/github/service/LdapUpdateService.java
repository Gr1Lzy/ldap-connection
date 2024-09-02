package com.github.service;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;

import javax.naming.directory.DirContext;
import javax.naming.directory.ModificationItem;

public class LdapUpdateService {
    private final DirContext context;

    public LdapUpdateService(DirContext context) {
        this.context = context;
    }

    public void update(String dn, Attribute attribute) throws NamingException {
        ModificationItem[] mods = new ModificationItem[1];
        mods[0] = new ModificationItem(DirContext.REPLACE_ATTRIBUTE, attribute);

        context.modifyAttributes(dn, mods);
        System.out.println("Updated the surname successfully.");
    }
}
