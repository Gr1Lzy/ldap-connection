package com.github.attribute;

import lombok.Getter;

@Getter
public enum AttributeEnum {
    ORGANIZATION("o", "organization"),
    COUNTRY("c", "country"),
    LOCALITY("l", "locality"),
    STAT_OF_PROVINCE("st", "stateOfProvince"),
    EMAIL_ADDRESS("mail", "emailAddress"),
    TELEPHONE_NUMBER("telephoneNumber", "telephoneNumber"),
    TITLE("title", "title"),
    USER_ID("uid", "userId"),
    OBJECT_CLASS("objectClass", "objectClass"),
    DESCRIPTION("description", "description"),
    GIVEN_NAME("givenName", "givenName"),
    ORGANIZATION_UNIT("ou","organizationUnit"),
    COMMON_NAME("cn", "commonName"),
    DISTINGUISHED_NAME("dc", "distinguishedName"),
    SURNAME("sn", "surname"),
    TOP("top", "top");

    private final String key;
    private final String value;

    AttributeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
