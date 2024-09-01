package com.github.objectclass;
import javax.naming.directory.Attribute;

public class Person extends Top {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = super.getAttribute();
        objectClass.add("person");
        return objectClass;
    }
}
