package game;

public class Game {
    private final PlayerAccount firstPlayer;            // 'X'
    private final PlayerAccount secondPlayer;           // 'O'
    private Board board;

    public Game(PlayerAccount firstPlayer, PlayerAccount secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.board = new Board();
    }

    public PlayerAccount play() {
        PlayerAccount currentPlayer = firstPlayer;          // X always make a turn first
        // game loop
        while (true) {
            // TODO: *refactor to make less code inside here
            System.out.println(board);
            System.out.println("Гравець " + currentPlayer.nickname + ", поставте " + currentPlayer.mark);
            // player makes his move
            try {
                currentPlayer.putMark(board);
            } catch (ExitGameException e) {
                System.out.println("Ви вирішили зупинити гру");
            } catch (RestartGameException e) {
                System.out.println("Гра розпочинається заново...");
                this.board = new Board();
                return play();
            }
            // check for draw
            if (board.isDraw()){
                currentPlayer.increaseRounds(false);
                nextPlayer(currentPlayer).increaseRounds(false);
                return null;
            }
            // check win
            if (board.isWin(currentPlayer)){
                System.out.println(board);
                currentPlayer.increaseRounds(true);
                nextPlayer(currentPlayer).increaseRounds(false);
                break;
            }
            // switch a player
            currentPlayer = nextPlayer(currentPlayer);
        }

        return currentPlayer;           // winner
    }

    private PlayerAccount nextPlayer(PlayerAccount currentPlayer) {
        if (currentPlayer.mark == 'X'){
            return secondPlayer;
        } else {
            return firstPlayer;
        }
    }
}
