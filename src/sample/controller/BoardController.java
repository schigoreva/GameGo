package sample.controller;

import sample.model.BoardModel;
import sample.view.ChangeTurnObserver;

public class BoardController {

    private BoardModel model;

    public BoardController(BoardModel model) {
        this.model = model;
    }

    public void addPiece(double x, double y) {
        model.addDoublePieces(x, y);
    }

    public boolean getTurn() {
        return model.getTurn();
    }

    public void addObserver(ChangeTurnObserver observer) {
        model.addObserver(observer);
    }
}
