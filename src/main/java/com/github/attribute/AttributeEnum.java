package com.github.attribute;

import lombok.Getter;

@Getter
public enum AttributeEnum {
    OBJECT_CLASS("objectClass", "objectClass"),
    COMMON_NAME("cn", "commonName"),
    SURNAME("sn", "surname"),
    ORGANIZATION_UNIT_NAME("ou", "organization"),

    DOMAIN_COMPONENT("dc", "domainComponent"),

    ORGANIZATION("o", "organization"),
    ORGANIZATION_UNIT("ou", "organizationalUnitName");

    private final String key;
    private final String value;

    AttributeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
