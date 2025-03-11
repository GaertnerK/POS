import java.awt.*;
import java.util.Random;

public class GameOfLife {
    private boolean[][] board;
    private SimpleGraphicsLibrary simpleGraphicsLibrary;

    public GameOfLife(int width, int height) {
        this.board = new boolean[height][width];
        this.simpleGraphicsLibrary = new SimpleGraphicsLibrary(width, height, Color.BLACK);
    }

    public boolean[][] getBoard() {
        return board;
    }

    public void loadBoard() {
        Random rand = new Random();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = rand.nextBoolean();
                if (board[i][j]) {
                    simpleGraphicsLibrary.setPixel(i, j, Color.YELLOW);
                }else {
                    simpleGraphicsLibrary.setPixel(i, j, Color.black);
                }
            }
        }
    }

    public void nextGen() {
        int neighbor = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                neighbor = checkNeighbor(i, j);
                if (board[i][j]){
                    if (neighbor < 2){
                        board[i][j] = false;
                    }else if (neighbor > 3) {
                        board[i][j] = false;
                    }
                }else {
                    if (neighbor == 3){
                        board[i][j] = true;
                    }
                }
                if (board[i][j]){
                    simpleGraphicsLibrary.setPixel(i, j, Color.YELLOW);
                }else {
                    simpleGraphicsLibrary.setPixel(i, j, Color.black);
                }
            }
        }
    }

    public int checkNeighbor(int row, int col) {
        int neighbor = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (row + i >= 0 && row + i < board.length && col + j >= 0 && col + j < board[0].length) {
                    if (board[row + i][col + j]) {
                        neighbor++;
                    }
                }
            }
        }
        return neighbor;
    }

    public boolean checkBoard(boolean[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != this.board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
