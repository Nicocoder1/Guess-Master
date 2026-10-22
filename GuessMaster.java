import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
    public static void main(String[] args) {
        System.out.println("Welcome to Guess Master");

        int maxAttempts = 7;
        int attempts = 0;
        boolean hasWon = false;

        Random random = new Random();
        int secretNumber = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);

        while (!hasWon && attempts < maxAttempts) {
            System.out.print("Attempt " + (attempts + 1) + "/" + maxAttempts + ": ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber && attempts == 1) {
                hasWon = true;
                System.out.println("Holy! It's your lucky day! You got it in the first try!");
            } else if (guess == secretNumber) {
                hasWon = true;
                System.out.println("You are correct!");
            } else if (guess < secretNumber) {

                System.out.println(hotColdHint(guess, secretNumber));
            } else {
                System.out.println(hotColdHint(guess, secretNumber));
            }
        }

        if (!hasWon) {
            System.out.println("Wah wah wahhhh, it was " + secretNumber + ". Better luck next time!");
        }

        scanner.close();
    }

    private static String hotColdHint(int guess, int secretNumber) {
        int distance = Math.abs(guess - secretNumber);

        if (distance <= 3) {
            return "You are scorching hot!";
        } else if (distance <= 10) {
            return "You are warm";
        } else if (distance <= 25) {
            return "You are cold";
        } else {
            return "You are freezing cold mae";
        }

    }
}