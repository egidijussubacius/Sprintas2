import java.util.Scanner;

public class aassa {
    public static void main(String args[]) {
        while (true) {
            System.out.println("Where would you like your adventure to begin? (Enter a number)\n");
            System.out.println("1. Play the Game\n2. Quit the Game");
            Scanner userInput = new Scanner(System.in);
            String userAction;
            try {
                userAction = userInput.nextLine().trim();
                if (userAction.equals("1")) {
                    pressPlay();
                } else if (userAction.equals("2")) {
                    System.exit(0);
                } else {
                    System.out.println("Sorry, your selection wasn't valid.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void pressPlay() {
    }
}
