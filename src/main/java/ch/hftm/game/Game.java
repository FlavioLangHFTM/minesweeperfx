package ch.hftm.game;

public class Game {

    // The size of the minefield
    // The field is always square so only one value is needed
    private int fieldSize;

    // How many mines should be added to the minefield
    private final int mineCount;

    // How many mines have been found by the user
    private int minesFound = 0;

    // The representation of the minefield itself as a two-dimensional array of
    // cells
    private Cell[][] mineField;

    public Game(int fieldSize, int mineCount) {
        this.fieldSize = fieldSize;
        this.mineCount = mineCount;
        this.mineField = new Cell[fieldSize][fieldSize];
    }

    // Populate the minefield, distribute mines randomly and calculate cell numbers
    public void startGame() {
        // TODO: Implement
    }

    // Process mouse Input and Reveal/Flag the clicked cell
    public void doTurn() {
        // TODO: Implement
    }

    // Check if the game is over
    public boolean isFinished() {
        // TODO: Implement
        return false;
    }

    // Getters and Setters

    public int getFieldSize() {
        return this.fieldSize;
    }

    public int getMineCount() {
        return this.mineCount;
    }

    public int getMinesFound() {
        return this.minesFound;
    }

    public void setMinesFound(int minesFound) {
        this.minesFound = minesFound;
    }

    public Cell[][] getMineField() {
        return this.mineField;
    }

}
