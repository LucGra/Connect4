import java.util.Objects;

public class Board {

  private final int rowCount;
  private final int columnCount;
  private final String[][] rows;

  public Board(int rowCount, int columnCount) {
    this.rowCount = rowCount;
    this.columnCount = columnCount;
    rows = new String[rowCount][columnCount];
  }

  public String toString() {
    StringBuilder board = new StringBuilder();
    for (int i = rowCount - 1; i >= 0; i--) {
      for (int j = 0; j < columnCount; j++) {
        board.append(String.format("|%3s ", rows[i][j] == null ? " " : rows[i][j]));
      }
      board.append("|\n");
    }
    for (int i = 0; i <= rowCount; i++)
      board.append(String.format(" %4s", i));
    board.append("\n");
    return board.toString();
  }

  public boolean isWinner(int winCondition) {
    // check for horizontal wins
    for (String[] row : this.rows) {
      for (int i = 0; i < this.columnCount - 4; i++) {
        if (row[i] != null && Objects.equals(row[i], row[i + 1])
            && Objects.equals(row[i], row[i + 2]) && Objects.equals(row[i], row[i
            + 3])) {
          System.out.println("WINNER!");
          return true;
        }
      }
    }
    // check for vertical wins
    for (int i = 0; i < this.rowCount - 4; i++) {
      for (int j = 0; j < this.columnCount; j++) {
        if (this.rows[i][j] != null && Objects.equals(this.rows[i][j], this.rows[i + 1][j])
            && Objects.equals(this.rows[i][j], this.rows[i + 2][j]) && Objects.equals(
            this.rows[i][j], this.rows[i + 3][j])) {
          System.out.println("WINNER");
          return true;
        }
      }
    }
    // check for ascending diagonal wins
    for (int i = 0; i < this.rowCount - 4; i++) {
      for (int j = 0; j < this.columnCount - 4; j++) {
        if (this.rows[i][j] != null && Objects.equals(this.rows[i][j], this.rows[i + 1][j + 1])
            && Objects.equals(this.rows[i][j], this.rows[i + 2][j + 2]) && Objects.equals(
            this.rows[i][j], this.rows[i + 3][j
                + 3])) {
          System.out.println("WINNER");
          return true;
        }
      }
    }
    // check for descending diagonal wins
    for (int i = 3; i < this.rowCount; i++) {
      for (int j = 0; j < columnCount - 3; j++) {
        if (this.rows[i][j] != null && Objects.equals(this.rows[i][j], this.rows[i - 1][j + 1])
            && Objects.equals(this.rows[i][j], this.rows[i - 2][j + 2]) && Objects.equals(
            this.rows[i][j], this.rows[i - 3][j
                + 3])) {
          System.out.println("WINNER");
          return true;
        }
      }
    }
    return false;
  }

  public boolean isLegalMove(int columnPosition) {
    if (columnPosition < 0) {
      return false;
    } else if (columnPosition < this.columnCount) {
      for (String[] row : this.rows) {
        if (row[columnPosition] == null) {  // there is a space available
          return true;
        }
      }
    } else {
      return false;
    }
    return false;
  }

  public void makeMove(int columnPosition, String playerCounter) {
    if (columnPosition < this.columnCount) {
      for (String[] row : this.rows) {
        if (row[columnPosition] == null) {
          row[columnPosition] = playerCounter;
          break;
        }
      }
    }
    System.out.println(this);
  }

  public int getColumnCount() {
    return this.columnCount;
  }
}