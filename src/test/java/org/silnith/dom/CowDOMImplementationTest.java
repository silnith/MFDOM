package org.silnith.dom;

import static org.junit.Assert.*;

import org.junit.Test;


public class CowDOMImplementationTest {
    
    private CowDOMImplementation impl = new CowDOMImplementation();
    
    @Test
    public void testHasFeature_Core_3point1() {
        assertFalse(impl.hasFeature("Core", "3.1"));
    }
    
    @Test
    public void testHasFeature_Core_3point0() {
        assertTrue(impl.hasFeature("Core", "3.0"));
    }
    
    @Test
    public void testHasFeature_Core_2point1() {
        assertTrue(impl.hasFeature("Core", "2.1"));
    }
    
    @Test
    public void testHasFeature_Core_2point0() {
        assertTrue(impl.hasFeature("Core", "2.0"));
    }
    
    @Test
    public void testHasFeature_Core_1point1() {
        assertTrue(impl.hasFeature("Core", "1.1"));
    }
    
    @Test
    public void testHasFeature_Core_1point0() {
        assertTrue(impl.hasFeature("Core", "1.0"));
    }
    
    @Test
    public void testHasFeature_Core_EmptyString() {
        assertTrue(impl.hasFeature("Core", ""));
    }
    
    @Test
    public void testHasFeature_Core_Null() {
        assertTrue(impl.hasFeature("Core", null));
    }
    
    @Test
    public void testHasFeature_Cow_Null() {
        assertTrue(impl.hasFeature("Cow", null));
    }
    
}
