/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anrad.record;

import com.anrad.dbo.StoreService;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 *
 * @author Radoselskiy
 */

@RunWith(JUnit4.class)
public class RecordStoreTest {
    
    public RecordStoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Inject @Any
    RecordStore rs;
    
    @Inject @Any
    private Instance<StoreService<Record, String>> store;
    
    private StoreService<Record, String> rs2;
    
     
    @Before
    public void setUp() throws NamingException {
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        rs = (RecordStore)container.getContext().lookup("java:global/classes/com/anrad/record/RecordStore");
    }
    
    @After
    public void tearDown() {
    }

    

    @Test
    public void testPut_Record() throws Exception {
        System.out.println("put");
        Record r = new Record("Name","Description");
        if (rs == null) System.out.println("Record Store is null");
        if (store == null) System.out.println("Record Store 2 is null");
        //rs.put(r);
        //RecordStore instance = new RecordStore();
        //instance.put(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
