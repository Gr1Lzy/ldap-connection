package com.github.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class LdapSearchService {
    private static final Logger logger = LoggerFactory.getLogger(LdapSearchService.class);
    private final DirContext context;

    public LdapSearchService(DirContext context) {
        this.context = context;
    }

    public void search(String dn, String filter, int searchControls) throws NamingException {
        SearchControls controls = new SearchControls();
        controls.setSearchScope(searchControls);

        NamingEnumeration<SearchResult> results = context.search(dn, filter, controls);

        while (results.hasMore()) {
            SearchResult result = results.next();
            logger.info("Found entry: {}", result.getNameInNamespace());
            Attributes attributes = result.getAttributes();
            NamingEnumeration<? extends Attribute> attrs = attributes.getAll();
            while (attrs.hasMore()) {
                Attribute attr = attrs.next();
                logger.info("{}: {}", attr.getID(), attr.get());
            }
        }
    }
}
