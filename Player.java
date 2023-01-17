import java.util.Random;

abstract class Player {

  public String counter;

  public String toString() {
    return counter;
  }

  public int getMove(int columnCount) {
    Random rand = new Random();
    return rand.nextInt(columnCount);
  }
}