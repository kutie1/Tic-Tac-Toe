package game;

public class Board {
    private final String[][] matrix;

    Board() {
        this.matrix = new String[3][];
        // TODO: init empty board
    }

    void putMark(int row, int column){
        // TODO: putMark()
    }

    boolean isWin(PlayerAccount player) {
        // TODO: isWin()
        return false;
    }

    boolean isDraw() {
        // TODO: isDraw()
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
