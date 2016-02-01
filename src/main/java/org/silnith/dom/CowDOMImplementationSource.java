package org.silnith.dom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DOMImplementationList;
import org.w3c.dom.DOMImplementationSource;


public class CowDOMImplementationSource implements DOMImplementationSource {
    
    @Override
    public DOMImplementation getDOMImplementation(final String features) {
        final DOMImplementationList domImplementationList = getDOMImplementationList(features);
        if (domImplementationList.getLength() > 0) {
            return domImplementationList.item(0);
        } else {
            return null;
        }
    }
    
    private static final Pattern FEATURE_PATTERN = Pattern.compile("(\\+?\\w+)(?: (\\d+\\.\\d+))?");
    
    @Override
    public DOMImplementationList getDOMImplementationList(final String features) {
        final Matcher matcher = FEATURE_PATTERN.matcher(features);
        final List<Feature> featureList = new ArrayList<>();
        while (matcher.find()) {
            final String name = matcher.group(1);
            final String version = matcher.group(2);
            featureList.add(new Feature(name, version));
        }
        final List<DOMImplementation> implementations = new ArrayList<>();
        outer: for (final DOMImplementation domImplementation : getImplementations()) {
            for (final Feature feature : featureList) {
                if (!domImplementation.hasFeature(feature.getName(), feature.getVersion())) {
                    continue outer;
                }
            }
            implementations.add(domImplementation);
        }
        return new CowDOMImplementationList(implementations);
    }
    
    private DOMImplementation getImplementation() {
        return new CowDOMImplementation();
    }
    
    private Iterable<DOMImplementation> getImplementations() {
        return Collections.singletonList(getImplementation());
    }
    
    private static class Feature {
        
        private final String name;
        
        private final String version;
        
        public Feature(final String name, final String version) {
            super();
            this.name = name;
            this.version = version;
        }
        
        public String getName() {
            return name;
        }
        
        public String getVersion() {
            return version;
        }
        
    }
    
}
