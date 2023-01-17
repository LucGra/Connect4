public class ConnectFour {

  private Board board;
  private HumanPlayer[] humanPlayers;
  private MachinePlayer[] machinePlayers;
  private int winCondition;

  public ConnectFour(int rows, int columns, int humanPlayerCount, int machinePlayerCount,
      int winCondition) {
    this.board = new Board(rows, columns);
    this.humanPlayers = new HumanPlayer[humanPlayerCount];
    this.machinePlayers = new MachinePlayer[machinePlayerCount];
    this.winCondition = winCondition;

    // instantiate human players
    for (int i = 0; i < humanPlayerCount; i++) {
      String playerCounter = "p" + String.valueOf(i + 1);
      humanPlayers[i] = new HumanPlayer(playerCounter);
    }
    // instantiate computer players
    for (int i = 0; i < machinePlayerCount; i++) {
      String playerCounter = "m" + String.valueOf(i + 1);
      machinePlayers[i] = new MachinePlayer(playerCounter);
    }
  }

  public void showPlayers() {
    for (HumanPlayer player : humanPlayers) {
      System.out.printf("Human Player: %s\n", player);
    }
    for (MachinePlayer player : machinePlayers) {
      System.out.printf("Machine Player: %s\n", player);
    }
  }

  public void printBoard() {
    System.out.println(board);
  }

  public void startGame() {
    while (!board.isWinner(this.winCondition)) {
      // process human moves
      for (HumanPlayer player : humanPlayers) {
        int playerMove;
        do {
          playerMove = player.getMove();
        } while (!board.isLegalMove(playerMove));
        board.makeMove(playerMove, player.toString());
      }
      // process machine moves
      for (MachinePlayer player : machinePlayers) {
        int machineMove;
        do {
          machineMove = player.getMove(board.getColumnCount());
        } while (!board.isLegalMove(machineMove));
        board.makeMove(machineMove, player.toString());
      }
    }
  }
}