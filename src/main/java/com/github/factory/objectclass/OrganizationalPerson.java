package com.github.factory.objectclass;

import javax.naming.directory.Attribute;

public class OrganizationalPerson extends Person {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = super.getAttribute();
        objectClass.add("organizationalPerson");
        return objectClass;
    }
}
