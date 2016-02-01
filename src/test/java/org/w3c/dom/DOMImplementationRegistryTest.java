package org.w3c.dom;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.silnith.dom.CowDOMImplementation;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;


/**
 * This tests that the COW DOM can be bootstrapped and used through the standard
 * DOM bootstrap mechanism.
 * 
 * @author Kent Rosenkoetter
 */
public class DOMImplementationRegistryTest {
    
    private DOMImplementationRegistry registry;
    
    @Before
    public void setUp() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassCastException {
        registry = DOMImplementationRegistry.newInstance();
    }
    
    @Test
    public void testGetDOMImplementation_Cow()
            throws ClassNotFoundException, InstantiationException, IllegalAccessException, ClassCastException {
        final DOMImplementation domImplementation = registry.getDOMImplementation("Cow");
        
        assertNotNull(domImplementation);
        assertThat(domImplementation, instanceOf(CowDOMImplementation.class));
    }
    
}
