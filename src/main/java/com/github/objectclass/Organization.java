package com.github.objectclass;

import javax.naming.directory.Attribute;

public class Organization extends Top {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = super.getAttribute();
        objectClass.add("organization");
        return objectClass;
    }
}
