package kov;

public class Main {
    public static void main(String[] args) {
        final Board board=new Board();
        final Game game = new Game();
        final TwoPlayersGame twoPlayersGame =
                new TwoPlayersGame("First", "Second");
        twoPlayersGame.printPlayer1Name();
        twoPlayersGame.printPlayer2Name();
        printGameNameAndBoard(twoPlayersGame,board);

        System.out.println();

        final ThreePlayersGame threePlayersGame =
                new ThreePlayersGame("First", "Second", "Third");
        threePlayersGame.printPlayer1Name();
        threePlayersGame.printPlayer2Name();
        threePlayersGame.printPlayer3Name();
        printGameNameAndBoard(twoPlayersGame,board);

    }

    private static void printGameNameAndBoard(final Game game, final Board board) {
        game.printGameName();
        System.out.println("==============");
        board.printBoard();

    }

}
