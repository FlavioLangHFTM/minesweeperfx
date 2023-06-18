package ch.hftm;

import java.io.IOException;

import ch.hftm.game.Cell;
import ch.hftm.game.Game;
import javafx.fxml.FXML;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

public class MainScreenController {

    private Game game;

    @FXML
    private GridPane mineFieldPane;

    @FXML
    private void startEinfach() {
        this.clearGame();
        this.game = new Game(9, 10);
        this.startGame();
    }

    @FXML
    private void startMittel() {
        this.clearGame();
        this.game = new Game(13, 15);
        this.startGame();
    }

    @FXML
    private void startSchwer() {
        this.clearGame();
        this.game = new Game(17, 20);
        this.startGame();
    }

    public void startGame() {

        this.mineFieldPane.getColumnConstraints().clear();
        this.mineFieldPane.getRowConstraints().clear();

        this.game.startGame();
        for (int x = 0; x < this.game.getFieldSize(); x++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / (double) this.game.getFieldSize());
            columnConstraints.setFillWidth(true);
            columnConstraints.setHgrow(Priority.ALWAYS);
            this.mineFieldPane.getColumnConstraints().add(columnConstraints);

            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / (double) this.game.getFieldSize());
            rowConstraints.setFillHeight(true);
            rowConstraints.setVgrow(Priority.ALWAYS);
            this.mineFieldPane.getRowConstraints().add(rowConstraints);

            for (int y = 0; y < this.game.getFieldSize(); y++) {
                Cell cell = this.game.getMineField()[x][y];
                this.mineFieldPane.add(cell, cell.getX(), cell.getY());
            }
        }
    }

    public void clearGame() {
        this.game = null;
        this.mineFieldPane.getChildren().clear();
    }

}
