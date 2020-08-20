package sample.controller;

import sample.model.BoardModel;

public class BoardController {

    private BoardModel model;

    public BoardController(BoardModel model) {
        this.model = model;
    }

    public void addPiece(double x, double y) {
        model.addPieces(x, y);
    }

    public boolean getTern() {
        return model.getTurn();
    }
}
