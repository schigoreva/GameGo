package sample.view;

import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.controller.BoardController;

import static sample.Preferences.*;

public class InfoView extends Group implements ChangeTurnObserver {
    private BoardController board;
    private Text currentPlayerText;

    public InfoView(BoardView boardView) {
        board = boardView.getController();
        currentPlayerText = new Text(BLACK_TURN_TEXT);
        currentPlayerText.setFont(Font.font("verdana", FontWeight.BOLD, 30));
        currentPlayerText.setX(APP_SIZE + CELL_SIZE);
        currentPlayerText.setY(CELL_SIZE);
        board.addObserver(this);
        //currentPlayerText.setTranslateX(20);
        //currentPlayerText.setTranslateY(20);
        this.getChildren().add(currentPlayerText);
    }

    @Override
    public void updateBoard() {
        currentPlayerText.setText(board.getTurn() ? "Ход черных" : "Ход белых");
    }
}
