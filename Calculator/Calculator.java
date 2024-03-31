import java.util.Scanner;

public class Calculator {
    float a, b; // Private member variables to store two numbers

    public void result() // Function to perform calculations
    {
        Scanner scanner = new Scanner(System.in);
        int choice; // Variable to store user's choice
        do {
            // Displaying menu options
            System.out.println("Enter 1 to Add 2 Numbers\n" +
                    "Enter 2 to Subtract 2 Numbers\n" +
                    "Enter 3 to Multiply 2 Numbers\n" +
                    "Enter 4 to Divide 2 Numbers\n" +
                    "Enter 0 To Exit");
            System.out.print("Enter Choice: ");
            choice = scanner.nextInt(); // Getting user's choice

            if (choice == 0) { // If choice is 0, exit the loop
                System.out.println("Exiting program...");
                return;
            }

            // Getting two numbers from the user
            System.out.print("Enter First Number: ");
            a = scanner.nextFloat();
            System.out.print("Enter Second Number: ");
            b = scanner.nextFloat();

            // Performing the operation based on user's choice
            switch (choice) {
                case 1:
                    System.out.println("Result: " + (a + b)); // Addition
                    break;
                case 2:
                    System.out.println("Result: " + (a - b)); // Subtraction
                    break;
                case 3:
                    System.out.println("Result: " + (a * b)); // Multiplication
                    break;
                case 4:
                    if (b == 0) {
                        System.out.println("Division By Zero"); // Handling division by zero
                    } else {
                        System.out.println("Result: " + (a / b)); // Division
                    }
                    break;
                default:
                    System.out.println("Invalid choice"); // Handling invalid choices
            }

        } while (choice != 0); // Loop until choice is 0
        scanner.close();
    }

    public static void main(String[] args) {
        Calculator c = new Calculator(); // Creating an instance of the Calculator class
        c.result(); // Calling the result function to start the calculator
    }
}
