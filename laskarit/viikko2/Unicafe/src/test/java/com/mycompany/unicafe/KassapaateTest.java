
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    Kassapaate paate;
    Maksukortti kortti;
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(1000);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void liianVahanRahaaEdullisesti() {
        paate.syoEdullisesti(200);
        assertTrue(paate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void liianVahanRahaaMaukkaasti() {
        paate.syoMaukkaasti(300);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kassassaRahaaOikeinEdullisesti() {
        paate.syoEdullisesti(240);
        assertTrue(paate.kassassaRahaa()== 100240);
    }
    
    @Test
    public void kassassaRahaaOikeinMaukkaasti() {
        paate.syoMaukkaasti(400);
        assertTrue(paate.kassassaRahaa() == 100400);
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaEdullisesti() {
        paate.syoEdullisesti(500);
        assertTrue(paate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void myytyjenLounaidenMaaraKasvaaMaukkaasti() {
        paate.syoMaukkaasti(500);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void korttiostoToimiiEdullisesti1() {
        assertTrue(paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void korttiostoToimiiEdullisesti2() {
        paate.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 760);
    }
    
    @Test
    public void korttiostoToimiiMaukkaasti1() {
        assertTrue(paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiostoToimiiMaukkaasti2() {
        paate.syoMaukkaasti(kortti);
        assertTrue(kortti.saldo() == 600);
    }
    
    @Test
    public void korttiostoLounaatKasvavatEdullisesti() {
        paate.syoEdullisesti(kortti);
        assertTrue(paate.edullisiaLounaitaMyyty() == 1);
    }
    
    @Test
    public void korttiostoLounaatKasvavatMaukkaasti() {
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 1);
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaa1() {
        kortti.otaRahaa(800);
        paate.syoMaukkaasti(kortti);
        paate.syoEdullisesti(kortti);
        assertTrue(kortti.saldo() == 200);
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaa2() {
        kortti.otaRahaa(800);
        paate.syoEdullisesti(kortti);
        assertTrue(paate.edullisiaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaa3() {
        kortti.otaRahaa(800);
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.maukkaitaLounaitaMyyty() == 0);
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaa4() {
        kortti.otaRahaa(800);
        assertTrue(!paate.syoEdullisesti(kortti));
    }
    
    @Test
    public void kortillaEiTarpeeksiRahaa5() {
        kortti.otaRahaa(800);
        assertTrue(!paate.syoMaukkaasti(kortti));
    }
    
    @Test
    public void korttiostoKassaRahaEiMuutu() {
        paate.syoEdullisesti(kortti);
        paate.syoMaukkaasti(kortti);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
    
    @Test
    public void kortilleRahanLataaminen1() {
        paate.lataaRahaaKortille(kortti, 5000);
        assertTrue(kortti.saldo() == 6000);
    }
    
    @Test
    public void kortilleRahanLataaminen2() {
        paate.lataaRahaaKortille(kortti, 5000);
        assertTrue(paate.kassassaRahaa() == 105000);
    }
    
    @Test
    public void kortilleRahanLataaminen3() {
        paate.lataaRahaaKortille(kortti, -1);
        assertTrue(paate.kassassaRahaa() == 100000);
    }
}
