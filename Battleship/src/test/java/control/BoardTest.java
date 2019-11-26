/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author eero
 */
public class BoardTest {
    Board board;
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        int t[][] = new int[10][10];
        t[1][2] = 1;
        board = new Board('A');
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void bombTest1() {
       assertTrue(board.bomb(2, 3) == 0);
    }
    
    @Test
    public void bombTest2() {
        assertTrue(board.bomb(1, 2) == 1);
    }
    
    @Test
    public void bombTest3() {
        board.bomb(1, 2);
        assertTrue(board.getTile(1, 2) == 2);
    }
}
