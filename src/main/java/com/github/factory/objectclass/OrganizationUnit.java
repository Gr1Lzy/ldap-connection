package com.github.factory.objectclass;

import javax.naming.directory.Attribute;

public class OrganizationUnit extends Top {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = super.getAttribute();
        objectClass.add("organizationUnit");
        return objectClass;
    }
}
