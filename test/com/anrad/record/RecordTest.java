package com.anrad.record;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Radoselskiy
 */
public class RecordTest {
    
    public RecordTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Record.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Record instance = new Record();
        String expResult = "";
        String result = instance.getId();
        assertNotNull(result);
        assertTrue(result.length() > 0);
        //assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Record.
     */
    @Test
    public void testSetGetName() {
        System.out.println("setName");
        String n = "Name";
        Record instance = new Record();
        instance.setName(n);
        String result = instance.getName();
        assertEquals(n, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Record.
     */
    @Test
    public void testSetGetDescription() {
        System.out.println("setDescription");
        String d = "Description";
        Record instance = new Record();
        instance.setDescription(d);
        String r = instance.getDescription();
        assertEquals(d, r);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Record.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Record instance = new Record("Name","Description");
        String expResult = "id = " + instance.getId() + "; name = " + "Name";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testEquals() {
        System.out.println("Equals");
        Record instance = new Record("Name","Description");
        Record instance2 = new Record("Name","Description");
        assertTrue(instance.equals(instance));
        assertFalse(instance.equals(instance2));
        assertFalse(instance.equals(null));
        assertFalse(instance.equals(new Object()));
    }
    
}
