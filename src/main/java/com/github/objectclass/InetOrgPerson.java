package com.github.objectclass;

import javax.naming.directory.Attribute;

public class InetOrgPerson extends OrganizationalPerson {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = super.getAttribute();
        objectClass.add("organizationUnit");
        return objectClass;
    }
}
