package com.github.service;

import com.github.objectclass.Organization;
import com.github.objectclass.OrganizationalUnit;
import com.github.objectclass.Person;

import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttributes;

import static com.github.attribute.AttributeEnum.*;

public class LdapAddService {

    public Attributes getOrganization(String o) {
        Attributes attributes = new BasicAttributes(true);
        attributes.put(new Organization().getAttribute());

        attributes.put(ORGANIZATION.getKey(), o);

        return attributes;
    }

    public Attributes getOrganizationUnit(String ou) {
        Attributes attributes = new BasicAttributes(true);
        attributes.put(new OrganizationalUnit().getAttribute());

        attributes.put(ORGANIZATIONAL_UNIT.getKey(), ou);

        return attributes;
    }

    public Attributes getPerson(String cn, String sn) {
        Attributes attributes = new BasicAttributes(true);
        attributes.put(new Person().getAttribute());

        attributes.put(COMMON_NAME.getKey(), cn);
        attributes.put(SURNAME.getKey(), sn);

        return attributes;
    }
}