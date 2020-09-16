package main.java.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import main.java.sample.view.BoardView;
import main.java.sample.view.InfoView;

import static main.java.sample.Preferences.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        BoardView boardView = new BoardView();
        InfoView infoView = new InfoView(boardView);
        root.getChildren().add(boardView);
        root.getChildren().add(infoView);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Игра Го");
        primaryStage.setScene(new Scene(root, APP_SIZE + INFO_WIDTH, APP_SIZE));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
