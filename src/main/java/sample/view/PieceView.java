package main.java.sample.view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import main.java.sample.Preferences;

public class PieceView extends Circle {
    Color color;
    int x;
    int y;

    public PieceView(Color color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
        this.setFill(color);
        this.setRadius(Preferences.PIECE_RADIUS);
        this.setCenterX(x * Preferences.CELL_SIZE);
        this.setCenterY(y * Preferences.CELL_SIZE);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PieceView)) {
            return false;
        }
        PieceView piece = (PieceView)obj;
        return piece.color == this.color && piece.x == this.x && piece.y == this.y;
    }
}
