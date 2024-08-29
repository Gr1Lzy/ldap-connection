package com.github.factory.objectclass;

import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;

import static com.github.attribute.AttributeEnum.*;

public class Organization implements ObjectClass {
    public Attribute create() {
        Attribute attribute = new BasicAttribute(OBJECT_CLASS.getValue());
        attribute.add(TOP.getValue());
        attribute.add(ORGANIZATION.getValue());

        return attribute;
    }
}
