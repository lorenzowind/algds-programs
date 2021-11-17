import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Queue queue = new Queue();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      System.out.print("Enter a command [e/d/q]: ");
      String option = scanner.next();

      switch (option) {
        case "e": {
          System.out.print("Enter an Integer: ");
          queue.enqueue(Integer.parseInt(scanner.next()));
          break;
        }
        case "d": {
          System.out.println("Removed Integer " + queue.dequeue());
          break;
        }
        case "q": {
          scanner.close();
          System.exit(0);
          break;
        }
        default: {
          System.out.println("Incorrect option!");
          break;
        }
      }

      queue.print();
    }
  }
}