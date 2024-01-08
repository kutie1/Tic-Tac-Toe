package game;

import java.util.Objects;

public class Board {
    private final String[][] matrix;

    Board() {
        this.matrix = new String[3][];
        // init empty board
        matrix[0] = new String[] {" ", " ", " "};
        matrix[1] = new String[] {" ", " ", " "};
        matrix[2] = new String[] {" ", " ", " "};
    }

    /**
     *
     * @param row 1, 2 or 3
     * @param column 1, 2 or 3
     */
    boolean putMark(int row, int column, char mark) {
        row -= 1;
        column -= 1;
        if (Objects.equals(matrix[row][column], " ")){
            matrix[row][column] = String.valueOf(mark);
            return true;
        }
        return false;
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
