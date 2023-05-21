// https://robertheaton.com/2018/07/20/project-2-game-of-life/

package com.gol;

public class App {
    public static void main(String[] args) throws InterruptedException {

        int res = 5;
        int width = 800;
        int height = 1200;

        int cols = width / res;
        int rows = height / res;

        BoardRender gui = new BoardRender(width, height, res);
        Board board = new Board(cols, rows, gui);

        while (true) {
            board.render();

            board.nextBoardState();

            Thread.sleep(60);
            gui.clearBoard();
        }

    }

}
