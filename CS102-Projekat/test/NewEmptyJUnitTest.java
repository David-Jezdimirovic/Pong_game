/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cs102.projekat.Igra;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Windows 8
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    
    
    
    @Test
     public void igraTest1() {
     int dimX = 800;
     int pozX = 801;
     int korX = 2;
     Igra r = new Igra();
     int result = r.korak1(dimX, pozX, korX);
     int expected = -2;
     assertEquals(result, expected);
     }
    
      @Test
     public void igraTest2() {
     int dimY = 0;
     int pozY = -1;
     int korY = 2;
     Igra r = new Igra();
     int result = r.korak2(dimY, pozY, korY);
     int expected = -2;
     assertEquals(result, expected);
     }
    
    
    
    
}
