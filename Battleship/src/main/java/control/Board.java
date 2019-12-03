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
        if (a == 1) {
            board[x][y] = 2;
            shipSquares--;
        }
        else if (a == 0) board[x][y] = 3;
        return a;
    }

    public int getTile(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (x >= size || y >= size) {
            return 0;
        }
        return board[x][y];
    }

    public void setShipSquare(int x, int y) {
        board[x][y] = 1;
        shipSquares++;
    }

    public int getShipSquares() {
        return shipSquares;
    }

    public boolean setShip(int row, int column, boolean horizontal) {
        if (ships == 5) {
            return false;
        }

        if (horizontal && (column + (5 - ships) <= size)) {
            for (int i = 0; i < (5 - ships); i++) {
                if (getTile(row, column + i) != 0 || getTile(row - 1, column + i) != 0 || (getTile(row + 1, column + i) != 0)) {
                    return false;
                }
            }
            if (getTile(row, column + (5 - ships)) != 0) {
                return false;
            }
            if (getTile(row, column - 1) != 0) {
                return false;
            }
            for (int i = 0; i < (5 - ships); i++) {
                setShipSquare(row, column + i);
            }
            ships++;
            return true;
        }
        if (!horizontal && (row + (5 - ships) <= size)) {
            for (int i = 0; i < (5 - ships); i++) {
                if (getTile(row + i, column) != 0 || getTile(row + i, column - 1) != 0 || getTile(row + i, column + 1) != 0) {
                    return false;
                }
            }
            if (getTile(row + (5 - ships), column) != 0) {
                return false;
            }
            if (getTile(row - 1, column) != 0) {
                return false;
            }
            for (int i = 0; i < (5 - ships); i++) {
                setShipSquare(row + i, column);
            }
            ships++;
            return true;
        }
        return false;
    }

    public int getShips() {
        return ships;
    }

    public boolean lost() {
        return (shipSquares == 0);
    }

}
