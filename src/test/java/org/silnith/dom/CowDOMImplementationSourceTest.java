package org.silnith.dom;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.DOMImplementationList;


public class CowDOMImplementationSourceTest {
    
    private CowDOMImplementationSource source = new CowDOMImplementationSource();
    
    @Test
    public void testGetDOMImplementation() {
        final DOMImplementation domImplementation = source.getDOMImplementation("Core 3.0");
        
        assertNotNull(domImplementation);
        assertThat(domImplementation, instanceOf(CowDOMImplementation.class));
    }
    
    @Test
    public void testGetDOMImplementationList() {
        final DOMImplementationList domImplementationList = source.getDOMImplementationList("Core 3.0");
        
        assertNotNull(domImplementationList);
        assertEquals(1, domImplementationList.getLength());
        assertThat(domImplementationList.item(0), instanceOf(CowDOMImplementation.class));
    }
    
}
