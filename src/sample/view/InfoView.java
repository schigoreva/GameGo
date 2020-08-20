package sample.view;

import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import sample.controller.BoardController;

import static sample.Preferences.BLACK_TURN_TEXT;

public class InfoView extends Group {
    private BoardController board;
    private Text currentPlayerText;

    public InfoView(BoardView boardView) {
        board = boardView.getController();
        currentPlayerText = new Text(BLACK_TURN_TEXT);
        currentPlayerText.setFont(Font.font("verdana", FontWeight.BOLD, 30));
        currentPlayerText.setX(20);
        currentPlayerText.setY(20);
       // currentPlayerText.setTranslateX(20);
      //  currentPlayerText.setTranslateY(20);
        this.getChildren().add(currentPlayerText);
    }
}
