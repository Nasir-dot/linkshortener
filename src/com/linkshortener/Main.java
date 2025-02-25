package com.linkshortener;
import java.util.Scanner;
public class Main { public static void main(String[] args) {
    LinkShortener shortener = new LinkShortener();
    Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("\nChoose an option:");
        System.out.println("1. Shorten a URL");
        System.out.println("2. Expand a URL");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (choice == 1) {
            System.out.print("Enter the long URL: ");
            String longURL = scanner.nextLine();
            String shortURL = shortener.shortenURL(longURL);
            System.out.println("Shortened URL: " + shortURL);
        } else if (choice == 2) {
            System.out.print("Enter the short URL: ");
            String shortURL = scanner.nextLine();
            String longURL = shortener.expandURL(shortURL);
            System.out.println("Original URL: " + longURL);
        } else if (choice == 3) {
            System.out.println("Exiting program...");
            break;
        } else {
            System.out.println("Invalid choice! Please try again.");
        }
    }

    scanner.close();
}

}
