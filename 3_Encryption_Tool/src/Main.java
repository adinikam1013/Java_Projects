import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose Mode: 1. Caesar Cipher  2. AES Encryption");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String result = "";

        if (choice == 1) {
            System.out.print("Enter Caesar key (int): ");
            int key = scanner.nextInt();
            result = CaesarCipher.encrypt(text, key);
        } else if (choice == 2) {
            System.out.print("Enter AES key (16 chars): ");
            String key = scanner.nextLine();
            result = AESEncryption.encrypt(text, key);
        } else {
            System.out.println("Invalid choice.");
            System.exit(0);
        }

        System.out.println("Encrypted Text: " + result);

        System.out.print("Save to file? (yes/no): ");
        String save = scanner.next();
            if (save.equalsIgnoreCase("yes")) {
                try {
                    File dir = new File("output");
                        if (!dir.exists()) {
                        dir.mkdir();  // Create output directory if it doesn't exist
                        }
                    try (FileWriter fw = new FileWriter("output/encrypted.txt")) {
                    fw.write(result);
                    System.out.println("Saved to output/encrypted.txt");
                    }
                } catch (IOException e) {
                System.out.println("Failed to write file: " + e.getMessage());
                }
        scanner.close();
        }
    }
}
