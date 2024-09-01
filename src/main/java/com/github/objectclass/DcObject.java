package com.github.objectclass;

import javax.naming.directory.Attribute;

public class DcObject extends Top {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = super.getAttribute();
        objectClass.add("dcObject");
        return objectClass;
    }
}
