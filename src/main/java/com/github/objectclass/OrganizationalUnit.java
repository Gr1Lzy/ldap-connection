package com.github.objectclass;

import javax.naming.directory.Attribute;

public class OrganizationalUnit extends Top {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = super.getAttribute();
        objectClass.add("organizationalUnit");
        return objectClass;
    }
}
