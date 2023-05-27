package ch.hftm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ch.hftm.game.Game;
import ch.hftm.game.Cell;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    public static void main(String[] args) {

        Game testGame = new Game(9, 10);

        System.out.println("Game:");
        System.out.println(testGame.toString());

        List<Cell> cells = new ArrayList<Cell>();

        for (int i = 0; i < 10; i++) {
            Cell cell = new Cell(testGame, i, i, false);
            cells.add(cell);
        }

        System.out.println("Cells:");
        for (Cell cell : cells) {
            System.out.println(cell.toString());
        }

        // launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("mainScreen"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setSceneRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

}