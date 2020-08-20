package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import sample.view.BoardView;
import sample.view.InfoView;

import static sample.Preferences.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox root = new HBox();
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
