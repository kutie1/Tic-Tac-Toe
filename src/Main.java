import game.Game;
import game.PlayerAccount;
import game.Storage;

import java.util.Scanner;

public class Main {

    static PlayerAccount getPlayer(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        String nickname = scanner.nextLine();               // do not check for validity
        if (nickname.trim().isEmpty()) {
            return getPlayer(text);
        }
        Storage storage = Storage.getInstance();
        if (storage.isPlayerPresent(nickname)) {
            // повідомити, що гравець із цим ніком вже існує
            System.out.printf("З поверненням %s! Гарної гри!\n", nickname);

            return storage.getPlayer(nickname);
        }
        // створити нового гравця, та повідомити, що він новий
        System.out.printf("Вітаю, %s! Уперше бачу вас у нашій грі:)\n", nickname);
        PlayerAccount player = new PlayerAccount(nickname);
        storage.saveNewPlayer(player);

        return player;
    }

    public static void main(String[] args) {
        PlayerAccount firstPlayer = getPlayer("Перший гравець (X) введіть своє ім'я: ");
        PlayerAccount secondPlayer = getPlayer("Другий гравець (O) введіть своє ім'я: ");

        firstPlayer.mark = 'X';                 // first must be X
        secondPlayer.mark = 'O';                // then second is O

        Game game = new Game(firstPlayer, secondPlayer);
        PlayerAccount winner = game.play();

        if (winner == null) {
            System.out.println("Нічия :/");
        } else {
            System.out.printf("Гравець %s, переміг! Вітаю!\n", winner.nickname);
        }

        Storage storage = Storage.getInstance();
        storage.saveChanges();
    }

}
