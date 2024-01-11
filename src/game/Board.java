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
        System.out.println("Це місце зайняте, спробуйте ще раз");
        return false;
    }

    boolean isWin(PlayerAccount player) {
        String mark = String.valueOf(player.mark);
        return Objects.equals(matrix[0][0], mark) && matrix[0][0].equals(mark) && Objects.equals(matrix[0][1], mark) && Objects.equals(matrix[0][2], mark) ||
                Objects.equals(matrix[1][0], mark) && Objects.equals(matrix[1][1], mark) && Objects.equals(matrix[1][2], mark) ||
                Objects.equals(matrix[2][0], mark) && Objects.equals(matrix[2][1], mark) && Objects.equals(matrix[2][2], mark) ||
                Objects.equals(matrix[0][2], mark) && Objects.equals(matrix[1][2], mark) && Objects.equals(matrix[2][2], mark) ||
                Objects.equals(matrix[0][1], mark) && Objects.equals(matrix[1][1], mark) && Objects.equals(matrix[2][1], mark) ||
                Objects.equals(matrix[0][0], mark) && Objects.equals(matrix[1][0], mark) && Objects.equals(matrix[2][0], mark) ||
                Objects.equals(matrix[0][2], mark) && Objects.equals(matrix[1][1], mark) && Objects.equals(matrix[2][0], mark) ||
                Objects.equals(matrix[0][0], mark) && Objects.equals(matrix[1][1], mark) && Objects.equals(matrix[2][2], mark);
    }

    boolean isDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (Objects.equals(matrix[row][col], " ")) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        // TODO: display board
        return String.format("""
                | %s | %s | %s |
                | %s | %s | %s |
                | %s | %s | %s |""",
                matrix[0][0], matrix[0][1], matrix[0][2],
                matrix[1][0], matrix[1][1], matrix[1][2],
                matrix[2][0], matrix[2][1], matrix[2][2]
                );
    }
}
