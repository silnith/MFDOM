package org.silnith.dom;

import java.util.List;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DOMImplementationList;


public class CowDOMImplementationList implements DOMImplementationList {
    
    private final List<DOMImplementation> implementationList;
    
    public CowDOMImplementationList(final List<DOMImplementation> implementations) {
        super();
        this.implementationList = implementations;
    }
    
    @Override
    public int getLength() {
        return implementationList.size();
    }
    
    @Override
    public DOMImplementation item(final int index) {
        return implementationList.get(index);
    }
    
}
