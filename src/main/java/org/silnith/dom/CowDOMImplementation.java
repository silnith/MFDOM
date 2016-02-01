package org.silnith.dom;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;


public class CowDOMImplementation implements DOMImplementation {
    
    private static final Map<String, BigDecimal> FEATURE_VERSIONS;
    
    static {
        final BigDecimal threePointZero = new BigDecimal("3.0");
        FEATURE_VERSIONS = new HashMap<>();
        FEATURE_VERSIONS.put("Cow".toUpperCase(Locale.ENGLISH), BigDecimal.ONE);
        FEATURE_VERSIONS.put("Core".toUpperCase(Locale.ENGLISH), threePointZero);
        FEATURE_VERSIONS.put("XML".toUpperCase(Locale.ENGLISH), threePointZero);
        FEATURE_VERSIONS.put("CSS".toUpperCase(Locale.ENGLISH), threePointZero);
    }
    
    @Override
    public Document createDocument(final String namespaceURI, final String qualifiedName, final DocumentType doctype)
            throws DOMException {
        return null;
    }
    
    @Override
    public DocumentType createDocumentType(final String qualifiedName, final String publicId, final String systemId)
            throws DOMException {
        return null;
    }
    
    @Override
    public Object getFeature(final String feature, final String version) {
        return null;
    }
    
    @Override
    public boolean hasFeature(final String feature, final String version) {
        final String upperCaseFeature = feature.toUpperCase(Locale.ENGLISH);
        if ( !FEATURE_VERSIONS.containsKey(upperCaseFeature)) {
            return false;
        }
        final BigDecimal featureVersion = FEATURE_VERSIONS.get(upperCaseFeature);
        if (version == null || version.isEmpty()) {
            return true;
        }
        final BigDecimal requestedVersion = new BigDecimal(version);
        if (featureVersion.compareTo(requestedVersion) >= 0) {
            return true;
        }
        return false;
    }
    
}
