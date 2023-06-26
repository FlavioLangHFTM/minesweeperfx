package ch.hftm.game;

public class Cell {

    // The instance of the Game the cell is part of
    private final Game game;

    // X and Y coordinates of the cell
    private final int x, y;

    // Is the cell a mine
    private final boolean isMine;

    // Is the cell revealed
    private boolean isRevealed = false;

    // How many mines are in proximity to the cell
    private int minesInProximity;

    // The immediate neighbours of the cell
    private Cell[] neighbours;

    public Cell(Game game, int x, int y, boolean isMine) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }

    // Find neighbours of the cell
    public void findNeighbours() {
        // TODO: Implement
    }

    // Reveal the current cell
    public void reveal() {
        // TODO: Implement
    }

    // Getters and Setters

    public Game getGame() {
        return this.game;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean getIsMine() {
        return this.isMine;
    }

    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    public void setIsRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    public int getMinesInProximity() {
        return this.minesInProximity;
    }

    public Cell[] getNeighbours() {
        return this.neighbours;
    }
}
