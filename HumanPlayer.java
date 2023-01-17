import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HumanPlayer extends Player {

  private BufferedReader reader;

  public HumanPlayer(String playerCounter) {
    this.counter = playerCounter;
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public int getMove() {
    int userInput = Integer.MIN_VALUE;
    System.out.printf("Player %s: please enter a move\n", this.counter);
    try {
      userInput = Integer.parseInt(reader.readLine());
    } catch (Exception e) {
      System.out.println(e);
    } finally {
      return userInput;
    }
  }
}