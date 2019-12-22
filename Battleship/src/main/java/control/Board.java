package control;

/**
 * The class that controls one player's board. 
 * Each player may have 5 ships each. 
 *
 * 
 */
public class Board {

    int size = 10;
    int[][] board = new int[size][size];
    int shipSquares = 0;
    int ships = 0;
    /**
     * Bombard this board.
     * @param x Row
     * @param y Column
     * @return Returns whether the tile contained water (0), a ship (1) or an already bombed ship (2) or an already bombed water tile (3).
     *
     */
    public int bomb(int x, int y) {
        int a = board[x][y];
        if (a == 1) {
            board[x][y] = 2;
            shipSquares--;
        }
        else if (a == 0) board[x][y] = 3;
        return a;
    }
    
    /**
     * 
     * @param x Row
     * @param y Column
     * @return Returns whether the tile contains water (0), a ship (1) or an already bombed tile (2 or 3).
     */
    public int getTile(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }
        if (x >= size || y >= size) {
            return 0;
        }
        return board[x][y];
    }
    
    /**
     * Place one ship piece.
     * @param x Row
     * @param y Column
     */
    public void setShipSquare(int x, int y) {
        board[x][y] = 1;
        shipSquares++;
    }
    
    /**
     * 
     * @return Returns number of tiles with ships on them.
     */
    public int getShipSquares() {
        return shipSquares;
    }
    
    /**
     * 
     * @param row Row
     * @param column Column
     * @param horizontal true to place ship horizontally, false to place vertically.
     * @return returns true if placement of ship succeeded, otherwise false.
     */
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

    /**
     * 
     * @return Returns number of ships left. (1-5)
     */
    public int getShips() {
        return ships;
    }
    
    /**
     * 
     * @return Returns true if this board has 0 ships left, and thus, has lost.
     */
    public boolean lost() {
        return (shipSquares == 0);
    }

}
