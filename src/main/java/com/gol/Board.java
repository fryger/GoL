package com.gol;

import java.util.Random;

public class Board {
    private boolean[][] board;
    private int width;
    private int height;
    private BoardRender gui;

    public Board(int width, int height, BoardRender gui) {
        this.width = width;
        this.height = height;
        this.gui = gui;
        this.board = new boolean[height][width];
        generateRandomBoard();

    }

    private void generateRandomBoard() {

        Random random = new Random();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                board[i][j] = random.nextInt(2) == 0;

            }
        }
    }

    private boolean nextCellValue(int x, int y) {

        int live_neighbors = 0;

        // int start_x = x - 1 > 0 ? x - 1 : 0;
        // int end_x = x + 1 < height ? x + 1 : x;

        // int start_y = y - 1 > 0 ? y - 1 : 0;
        // int end_y = y + 1 < width ? y + 1 : y;

        // for (int i = start_x; i <= end_x; i++) {
        // for (int j = start_y; j <= end_y; j++) {
        // if (i == x && j == y) {
        // continue;
        // }
        // if (board[i][j]) {
        // live_neighbors++;
        // }
        // }
        // }

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (board[(x + i + height) % height][(y + j + width) % width]) {
                    live_neighbors++;
                }
            }
        }

        if (board[x][y]) {
            live_neighbors--;
        }

        if (board[x][y]) {
            if (live_neighbors <= 1) {
                return false;
            } else if (live_neighbors <= 3) {
                return true;
            } else {
                return false;
            }
        } else {
            if (live_neighbors == 3) {
                return true;
            }
        }

        return board[x][y];
    }

    public void nextBoardState() {

        boolean[][] state = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                state[i][j] = nextCellValue(i, j);
            }
        }

        board = state;
    }

    public void render() {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {

                if (board[i][j]) {
                    gui.addSquare(i, j);
                }

            }
        }
        gui.setVisible(true);

    }
}
