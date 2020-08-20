package sample.view;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import sample.controller.BoardController;
import sample.model.BoardModel;

import static sample.Preferences.*;

public class BoardView extends Group {

    private BoardController controller;
    private BoardModel model;
    private Rectangle background;
    private Rectangle clickListener;
    private Group piecesContainer;

    public BoardView() {
        this.background = new Rectangle(APP_SIZE, APP_SIZE, Color.BROWN);
        this.getChildren().add(this.background);
        this.model = new BoardModel();
        this.controller = new BoardController(model);
        for (int i = 0; i < COUNT_NODES; i++) {
            Rectangle vertical_line = new Rectangle(LINE_WIDTH, APP_SIZE, Color.BLACK);
            Rectangle horizontal_line = new Rectangle(APP_SIZE, LINE_WIDTH, Color.BLACK);
            vertical_line.setX(i * CELL_SIZE - LINE_WIDTH / 2);
            vertical_line.setY(0);
            horizontal_line.setX(0);
            horizontal_line.setY(i * CELL_SIZE - LINE_WIDTH / 2);
            this.getChildren().add(vertical_line);
            this.getChildren().add(horizontal_line);
        }
        this.piecesContainer = new Group();
        this.getChildren().add(piecesContainer);
        this.clickListener = new Rectangle(APP_SIZE, APP_SIZE, Color.TRANSPARENT);
        this.getChildren().add(clickListener);
        addListeners();
    }

    private void addListeners() {
        this.clickListener.setOnMouseClicked(event -> {
            controller.addPiece(event.getX(), event.getY());
        });
        this.model.addObserver(this);
    }

    public void updateBoard() {
        this.piecesContainer.getChildren().clear();
        PieceView[][] board = model.getPieces();
        for (int i = 0; i < COUNT_NODES; i++) {
            for (int j = 0; j < COUNT_NODES; j++) {
                if (board[i][j] != null) {
                    this.piecesContainer.getChildren().add(board[i][j]);
                }
            }
        }
    }

    public BoardController getController() {
        return controller;
    }
}
