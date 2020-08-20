package sample.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import sample.Preferences;

public class PieceView extends Circle {
    public PieceView(Color color, int x, int y) {
        this.setFill(color);
        this.setRadius(Preferences.PIECE_RADIUS);
        this.setCenterX(x * Preferences.CELL_SIZE);
        this.setCenterY(y * Preferences.CELL_SIZE);
    }
}
