class Main {

  public static void main(String[] args) {
    int gameRows = 6;
    int gameColumns = 7;
    int humanPlayers = 1;
    int machinePlayers = 1;
    int winCondition = 4;

    ConnectFour game = new ConnectFour(gameRows, gameColumns, humanPlayers, machinePlayers,
        winCondition);

    game.showPlayers();
    game.printBoard();
    game.startGame();
  }
}