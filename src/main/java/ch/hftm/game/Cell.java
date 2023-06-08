package ch.hftm.game;

public class Cell {

    // The instance of the Game the cell is part of
    private final Game game;

    // X and Y coordinates of the cell
    private final int x, y;

    // Is the cell a mine
    private boolean isMine;

    // Is the cell revealed
    private boolean isRevealed = false;

    // Is the cell flagged as a mine
    private boolean isFlagged = false;

    // How many mines are in proximity to the cell
    private int minesInProximity;

    // The immediate neighbours of the cell (north, east, south, west), only used
    // for revealing multiple cells
    private Cell[] neighbours = new Cell[4];

    public Cell(Game game, int x, int y, boolean isMine) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }

    // Find neighbours of the cell
    public void findNeighbours() {

        // Search coordinates for all 8 surrounding cells
        int[][] neighbourCoordinates = {
                { -1, -1 },
                { 0, -1 },
                { 1, -1 },
                { -1, 0 },
                { 1, 0 },
                { -1, 1 },
                { 0, 1 },
                { 1, 1 }
        };

        for (int[] i : neighbourCoordinates) {
            Cell cell = this.game.getCell(this.x + i[0], this.y + i[1]);
            if (cell != null && cell.getIsMine()) {
                this.minesInProximity++;
            }
        }

        // Find the four neighbouring cells
        this.neighbours[0] = this.game.getCell(this.x, this.y - 1); // North
        this.neighbours[0] = this.game.getCell(this.x + 1, this.y); // East
        this.neighbours[0] = this.game.getCell(this.x, this.y + 1); // South
        this.neighbours[0] = this.game.getCell(this.x - 1, this.y); // West
    }

    // Reveal the current cell
    public void reveal() {
        // TODO: Display the Cell according to the number of mines nearby

        // Only reveal recursively if the game is not yet finished
        if (!this.game.getIsFinished())
            // Reveal all the neighbouring cells that have no mines nearby
            for (Cell cell : this.neighbours) {
                if (cell != null && !cell.getIsRevealed() && cell.getMinesInProximity() == 0 && !cell.getIsMine()) {
                    cell.reveal();
                }
            }
    }

    // Flag the cell
    public void flag() {
        // TODO: Display Flag on cell
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

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean getIsRevealed() {
        return this.isRevealed;
    }

    public void setIsRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    public boolean getIsFlagged() {
        return this.isFlagged;
    }

    public void setIsFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    public int getMinesInProximity() {
        return this.minesInProximity;
    }

    public Cell[] getNeighbours() {
        return this.neighbours;
    }

    @Override
    public String toString() {
        return "{" +
                " game='" + getGame() + "'" +
                ", x='" + getX() + "'" +
                ", y='" + getY() + "'" +
                ", isMine='" + getIsMine() + "'" +
                ", isRevealed='" + getIsRevealed() + "'" +
                ", minesInProximity='" + getMinesInProximity() + "'" +
                ", neighbours='" + getNeighbours() + "'" +
                "}";
    }

}
