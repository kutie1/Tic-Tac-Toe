package game;

public class Game {
    private final PlayerAccount firstPlayer;
    private final PlayerAccount secondPlayer;
    private Board board;

    public Game(PlayerAccount firstPlayer, PlayerAccount secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.board = new Board();
    }

    void restartGame() {
        // TODO: restartGame()
    }

    public PlayerAccount play() {
        // TODO: play()
        return null;
    }
}
