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

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void bombTest1() {
        board.setShipSquare(1, 2);
        assertTrue(board.bomb(2, 3) == 0);
    }

    @Test
    public void bombTest2() {
        board.setShipSquare(1, 2);
        assertTrue(board.bomb(1, 2) == 1);
    }

    @Test
    public void bombTest3() {
        board.setShipSquare(1, 2);
        board.bomb(1, 2);
        assertTrue(board.getTile(1, 2) == 2);
    }

    @Test
    public void lostTest1() {
        board.setShipSquare(1, 2);
        board.bomb(1, 2);
        assertTrue(board.lost());
    }

    @Test
    public void lostTest2() {
        board.setShipSquare(1, 2);
        assertTrue(!board.lost());
    }
    
    @Test
    public void getTileTest1() {
        assertTrue(board.getTile(-1, 0) == 0);
    }
    
    @Test
    public void getTileTest2() {
        assertTrue(board.getTile(50, 0) == 0);
    }

    @Test
    public void setShipHorizontalTest1() {
        board.setShip(1, 2, true);
        assertTrue(board.getShipSquares() == 5);
    }
    
    @Test
    public void setShipHorizontalTest2() {
        board.setShip(1, 2, true);
        board.setShip(3, 2, true);
        assertTrue(board.getShipSquares() == 9);
    }
    
    @Test
    public void setShipHorizontalTest3() {
        board.setShip(1, 8, true);
        assertTrue(board.getShips() == 0);
    }
    
    @Test
    public void setShipVerticalTest1() {
        board.setShip(1, 2, false);
        assertTrue(board.getShips() == 1);
    }
    
    @Test
    public void setShipVerticalTest2() {
        board.setShip(8, 1, false);
        assertTrue(board.getShips() == 0);
    }
    
    @Test
    public void cantSet6ShipsTest() {
        for (int i = 0; i < 5; i++) {
            board.setShip((2 * i), 0, true);
        }
        assertTrue(!board.setShip(0, 9, false));
    }
    
    @Test
    public void cantSetHorizontalShipOnOtherShipTest() {
        board.setShip(0, 5, false);
        assertTrue(!board.setShip(0, 4, true));
    }
    
    @Test
    public void cantSetHorizontalShipNextToOtherShipTest1() {
        board.setShip(0, 5, false);
        assertTrue(!board.setShip(0, 1, true));
    }
    
    @Test
    public void cantSetHorizontalShipNextToOtherShipTest2() {
        board.setShip(0, 0, false);
        assertTrue(!board.setShip(0, 1, true));
    }
    
    @Test
    public void cantSetVerticalShipOnOtherShipTest() {
        board.setShip(5, 0, true);
        assertTrue(!board.setShip(4, 0, false));
    }

    @Test
    public void cantSetVerticalShipNextToOtherShipTest1() {
        board.setShip(5, 0, true);
        assertTrue(!board.setShip(1, 0, false));
    }

    @Test
    public void cantSetVerticalShipNextToOtherShipTest2() {
        board.setShip(5, 0, true);
        assertTrue(!board.setShip(6, 0, false));
    }
}
