/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author eero
 */
public class Board {
    char player;
    int size = 10;
    int[][] board = new int[size][size];
    int shipSquares = 0;
    int ships = 0;
    
    public Board(char c) {
        player = c;
    }
    
    public int bomb(int x, int y) {
        int a = board[x][y];
        board[x][y] = 2;
        if (a == 1) {
            shipSquares--;
        }
        return a;
    }
    
    public boolean dead() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[j][i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public int getTile(int x, int y) {
        if (x < 0 || y < 0) return 0;
        return board[x][y];
    }
    
    public void setShipSquare(int x, int y) {
        board[x][y] = 1;
        shipSquares++;
    }
    
    public int getShipSquares() {
        return shipSquares;
    }
    
    public boolean setShip(int x, int y, boolean horizontal) {
        if (ships == 5) return false;
        if (horizontal && (x + (5 - ships) <= 10)) {
            for (int i = 0; i < (5 - ships); i++) {
                if (getTile(x + i, y) != 0 || getTile(x + i, y - 1) != 0 || getTile(x + i, y + 1) != 0) return false;
            }
            if (getTile(x + (5 - ships), y) != 0) return false;
            if (getTile(x - 1, y) != 0) return false;
            for (int i = 0; i < (5 - ships); i++) {
                setShipSquare(x + i, y);
            }
            ships++;
            return true;
        }
        if (!horizontal && (y + (5 - ships) <= 10)) {
            for (int i = 0; i < (5 - ships); i++) {
                if (getTile(x, y + i) != 0 || getTile(x - 1, y + i) != 0 || getTile(x + 1, y + i) != 0) return false;
            }
            if (getTile(x, y + (5 - ships)) != 0) return false;
            if (getTile(x, y - 1) != 0) return false;
            for (int i = 0; i < (5 - ships); i++) {
                setShipSquare(x, y + i);
            }
            ships++;
            return true;
        }
        return false;
    }
    
    public int getShips() {
        return ships;
    }
    
}
