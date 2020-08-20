package sample.model;

import sample.view.*;

import static sample.Preferences.*;
import static sample.view.PieceType.*;

public class BoardModel {
    private static final int[][] neighbours = {
            {-1, 0},
            {1, 0},
            {0, 1},
            {0, -1}
    };

    private PieceView[][] board = new PieceView[COUNT_NODES][COUNT_NODES];
    private PieceType[][] type = new PieceType[COUNT_NODES][COUNT_NODES];
    private BoardView view;
    private boolean turn = true;

    public BoardModel() {
        for (int i = 0; i < COUNT_NODES; i++) {
            for (int j = 0; j < COUNT_NODES; j++) {
                type[i][j] = NONE;
            }
        }
    }

    public void addObserver(BoardView view) {
        this.view = view;
    }

    public void addPieces(double x, double y) {
        int cellX = (int) Math.floor((x + CELL_SIZE / 2.0) / CELL_SIZE);
        int cellY = (int) Math.floor((y + CELL_SIZE / 2.0) / CELL_SIZE);
        if (type[cellX][cellY] == NONE && checkNeighbours(cellX, cellY)) {
            if (!turn) {
                board[cellX][cellY] = new WhitePieceView(cellX, cellY);
                type[cellX][cellY] = WHITE;
            } else {
                board[cellX][cellY] = new BlackPieceView(cellX, cellY);
                type[cellX][cellY] = BLACK;
            }
            changeTurn();
            checkBoard();
            view.updateBoard();
        }
    }

    private boolean checkNeighbours(int x, int y) {
        for (int[] to : neighbours) {
            int toX = x + to[0];
            int toY = y + to[1];
            if (toX >= 0 && toY >= 0 && toX < COUNT_NODES && toY < COUNT_NODES) {
                if (type[toX][toY] == NONE || getCurrentColor() == type[toX][toY]) {
                    return true;
                }
            }
        }
        return false;
    }

    private PieceType getCurrentColor() {
        return turn ? BLACK : WHITE;
    }

    private boolean checkComponent(int x, int y, boolean[][] used, PieceType t) {
        boolean alive = false;
        used[x][y] = true;
        for (int[] to : neighbours) {
            int toX = x + to[0];
            int toY = y + to[1];
            if (toX >= 0 && toY >= 0 && toX < COUNT_NODES && toY < COUNT_NODES) {
                if (!used[toX][toY] && type[toX][toY] == t) {
                    if (checkComponent(toX, toY, used, t)) {
                        alive = true;
                    }
                } else if (type[toX][toY] == NONE) {
                    alive = true;
                }
            }
        }
        return alive;
    }

    private void clearComponent(int x, int y, boolean[][] used, PieceType t) {
        used[x][y] = true;
        board[x][y] = null;
        type[x][y] = NONE;
        for (int[] to : neighbours) {
            int toX = x + to[0];
            int toY = y + to[1];
            if (toX >= 0 && toY >= 0 && toX < COUNT_NODES && toY < COUNT_NODES && !used[toX][toY] && type[toX][toY] == t) {
                clearComponent(toX, toY, used, t);
            }
        }
    }

    private void checkBoard() {
        boolean[][] used = new boolean[COUNT_NODES][COUNT_NODES];
        boolean[][] usedClear = new boolean[COUNT_NODES][COUNT_NODES];
        for (int i = 0; i < COUNT_NODES; i++) {
            for (int j = 0; j < COUNT_NODES; j++) {
                if (type[i][j] != NONE && !used[i][j]) {
                    if (!checkComponent(i, j, used, type[i][j])) {
                        clearComponent(i, j, usedClear, type[i][j]);
                    }
                }
            }
        }
    }

    private void changeTurn() {
        turn = !turn;
    }

    public PieceView[][] getPieces() {
        return board;
    }

    public boolean getTurn() {
        return turn;
    }
}
