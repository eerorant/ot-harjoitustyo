package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void rahanLataaminen1() {
        kortti.lataaRahaa(5000);
        assertEquals("saldo: 50.10", kortti.toString());
    }
    
    @Test
    public void rahanOttaminen() {
        kortti.lataaRahaa(990);
        kortti.otaRahaa(500);
        assertTrue(kortti.saldo() == 500);
    }
    
    @Test
    public void rahanOttaminen2() {
        kortti.otaRahaa(100);
        assertTrue(kortti.saldo() == 10);
    }
    
    @Test
    public void rahanOttaminen3() {
        assertTrue(kortti.otaRahaa(10));
    }
    
    @Test
    public void rahanOttaminen4() {
        assertTrue(!kortti.otaRahaa(100));
    }
}
