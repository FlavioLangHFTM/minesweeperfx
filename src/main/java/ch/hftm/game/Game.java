package ch.hftm.game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private boolean isFinished = false;

    public Game(int fieldSize, int mineCount) {
        this.fieldSize = fieldSize;
        this.mineCount = mineCount;
        this.mineField = new Cell[fieldSize][fieldSize];
    }

    // Populate the minefield, distribute mines randomly and calculate cell numbers
    public void startGame() {

        // Populate the field with empty cells
        for (int x = 0; x < this.fieldSize; x++) {
            for (int y = 0; y < this.fieldSize; y++) {
                this.mineField[x][y] = new Cell(this, x, y, false);
            }
        }

        // Set the chosen cells to be mines
        for (Point p : generateMineLocations()) {
            this.mineField[(int) p.getX()][(int) p.getY()].setIsMine(true);
        }

        // Compute the number for every cell
        for (int x = 0; x < this.fieldSize; x++) {
            for (int y = 0; y < this.fieldSize; y++) {
                this.mineField[x][y].findNeighbours();
            }
        }
    }

    // Generate random mine locations
    public List<Point> generateMineLocations() {
        List<Point> locations = new ArrayList<Point>();
        Random random = new Random();
        while (locations.size() > this.mineCount) {
            Point point = new Point(random.nextInt(this.fieldSize), random.nextInt(this.fieldSize));
            boolean found = false;
            for (Point p : locations) {
                if ((int) point.getX() == (int) p.getX() && (int) point.getY() == (int) p.getY()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                locations.add(point);
            }
        }

        return locations;
    }

    // Process mouse Input and Reveal/Flag the clicked cell
    public void doTurn(int x, int y) {

        Cell clickedCell = this.getCell(x, y);
        if (clickedCell != null && !clickedCell.getIsRevealed()) {
            if (true) { // Reveal
                if (clickedCell.getIsMine()) {
                    this.isFinished = true;
                } else {
                    clickedCell.reveal();
                }
            } else { // Flag
                clickedCell.flag();
            }
        }

        if (this.isFinished || this.minesFound >= this.mineCount) {
            this.revealAll();
        }

    }

    // Reveal all cells when game is finished
    public void revealAll() {
        for (int x = 0; x < this.fieldSize; x++) {
            for (int y = 0; y < this.fieldSize; y++) {
                this.mineField[x][y].reveal();
            }
        }
    }

    // Get a cell by its coordinates in the minefield (checks out of bounds)
    public Cell getCell(int x, int y) {
        if ((x < 0 || x >= this.fieldSize) || (y < 0 || y >= this.fieldSize)) {
            return null;
        }
        return this.mineField[x][y];
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

    public boolean getIsFinished() {
        return this.isFinished;
    }

    @Override
    public String toString() {
        return "{" +
                " fieldSize='" + getFieldSize() + "'" +
                ", mineCount='" + getMineCount() + "'" +
                ", minesFound='" + getMinesFound() + "'" +
                ", mineField='" + getMineField() + "'" +
                "}";
    }

}
