package game;

import java.io.Serializable;

public class PlayerAccount implements Serializable {
    private final String nickname;
    transient private char mark;
    private int roundsWon;
    private int roundsPlayed;

    PlayerAccount(String nickname) {
        this.nickname = nickname;
        this.roundsWon = 0;
        this.roundsPlayed = 0;
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
    }

    void increaseRounds(boolean isWin) {
        this.roundsPlayed += 1;
        if (isWin) {
            this.roundsWon += 1;
        }
    }
}
