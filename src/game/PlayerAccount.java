package game;

import java.io.Serializable;
import java.util.Scanner;

public class PlayerAccount implements Serializable {
    public final String nickname;
    transient private char mark;
    private int roundsWon;
    private int roundsPlayed;

    public PlayerAccount(String nickname) {
        this.nickname = nickname;
        this.roundsWon = 0;
        this.roundsPlayed = 0;
    }

    private static int readNumber123(String text) {
        // TODO: readNumber123()
//        int number = 0;
//        while (true) {
//            System.out.print(text);
//            number = scanner.nextInt();
//            if (number == 1 || number == 2 || number == 3) {
//                break;
//            } else {
//                System.out.println("Введіть 1, 2, 3");
//            }
//        }
//        return number;
    }

    /**
     * Ставить this.mark на дошку за координатами, отриманими із консолі
     * 1. Отримання даних із консолі
     *     – перевірка, що це число 1, 2, 3
     * 2. Поставити на дошку
     *     – перевіряє чи туди можна ставити
     * 3. Кінець функції
     * @param board дошка, на якій розміщуються мітки
     */
    void putMark(Board board) {
        //TODO: putMark();
        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int column = 0;
        while (!board.putMark(row, column, mark)){
            row = readNumber123("Рядок: ");
            column = readNumber123("Стовпчик: ");
        }
        board.putMark(row, column, mark);
    }

    void increaseRounds(boolean isWin) {
        this.roundsPlayed += 1;
        if (isWin) {
            this.roundsWon += 1;
        }
    }
}
