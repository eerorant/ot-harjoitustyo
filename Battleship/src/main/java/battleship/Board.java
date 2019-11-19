/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package battleship;

/**
 *
 * @author eero
 */
public class Board {
    char player;
    int size = 10;
    int[][] board = new int[size][size];
    
    public Board(char c, int[][] t) {
        player = c;
        board = t;
    }
    
    public int bomb(int x, int y) {
        int a = board[x][y];
        board[x][y] = 2;
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
        return board[x][y];
    }
}
