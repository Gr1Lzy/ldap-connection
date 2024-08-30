package com.github.factory.objectclass;

import com.github.factory.ObjectClass;

import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;

public class Top implements ObjectClass {

    @Override
    public Attribute getAttribute() {
        Attribute objectClass = new BasicAttribute("objectClass");
        objectClass.add("top");
        return objectClass;
    }
}
