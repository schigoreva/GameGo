package sample.model;

import javafx.scene.paint.Color;
import org.junit.Test;
import sample.view.PieceView;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static sample.Preferences.COUNT_NODES;

public class Tests {
    @Test
    public void testAddPieces() {
        BoardModel testApp = new BoardModel();
        Random rd = new Random();
        int x = Math.abs(rd.nextInt()) % COUNT_NODES;
        int y = Math.abs(rd.nextInt()) % COUNT_NODES;
        testApp.addPieces(x, y);
        assertEquals(testApp.getPieces()[x][y], new PieceView(Color.BLACK, x, y));
    }

    @Test
    public void checkKills() {
        BoardModel testApp = new BoardModel();
        testApp.addPieces(1, 1); //Черные: Эта клетка должна быть съедена
        testApp.addPieces(1, 0); //Белые: Слева от 1, 1
        testApp.addPieces(5, 5); //Черные: Бесполезный ход
        testApp.addPieces(1, 2); //Белые: Справа от 1, 1
        testApp.addPieces(5, 6); //Черные: Бесполезный ход
        testApp.addPieces(0, 1); //Белые: Сверху от 1, 1
        testApp.addPieces(6, 5); //Черные: Бесполезный ход
        testApp.addPieces(2, 1); //Белые: Снизу от 1, 1
        assertEquals(testApp.getPieces()[1][1], null); //Проверка что клетки нет
    }

    @Test
    public void checkValidTurns() {
        BoardModel testApp = new BoardModel();
        assertTrue(testApp.checkValidMove(0, 1)); // Проверка что можно походить в пустую клетку
        testApp.addPieces(0, 1); //Ход черных
        testApp.addPieces(5, 5); //Ход белых
        testApp.addPieces(1, 0); //Ход черных (блок 0, 0)
        assertFalse(testApp.checkValidMove(0, 0)); //Клетка заблокирована
        assertFalse(testApp.checkValidMove(1, 0)); //Клетка занята
    }
}
