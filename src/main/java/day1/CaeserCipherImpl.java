package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CaeserCipherImpl {

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        start();
    }

    private static void start() {
        int option =0;
        do {
            System.out.print(
                    "Welcome to Gehtsoft Technical Assessment\n" +
                            "Please choose an option:\n" +
                            "1. Caesar Cipher Encryption\n" +
                            "2. Caesar Cipher Decryption  \n" +
                            "3. Arithmetic Expression Evaluation\n" +
                            "4. Exit\n" +
                            "\nEnter your choice: "
            );

            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            switch (option) {
                case 1 -> cipherCase(true);
                case 2 -> cipherCase(false);
                case 3 -> evaluateCase();
                case 4 -> System.out.println("Bye!");
                default -> System.out.println("Incorrect choice. Try again (1-4).");
            }
        } while (option != 4);
    }

    private static void cipherCase(boolean encrypt) {
        while (true) {
            System.out.print("Enter text: ");
            String text = sc.nextLine();

            System.out.print("Enter shift value (integer): ");
            int shift;

            try {
                shift = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Shift must be a number!");
                continue;
            }

            String result = encrypt
                    ? Caeser.encrypt(text, shift)
                    : Caeser.decrypt(text, shift);

            System.out.println("Result: " + result);

            if (!again()) break;
        }
    }

    private static void evaluateCase() {
        while (true) {
            System.out.print("Enter expression: ");
            String expr = sc.nextLine();
            try {
                System.out.println("Result: " + Evaluator.evaluate(expr));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
            if (!again()) break;
        }
    }

    private static boolean again() {
        System.out.print("Continue? (y/n): ");
        return sc.nextLine().equalsIgnoreCase("y");
    }

    /*
    private static void readFromFileCase() {
        System.out.print("Enter path to file: ");
        Path p = Path.of(sc.nextLine().trim());
        try {
            String content = Files.readString(p);
            System.out.println("File content:\n" + content);
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }*/
}
