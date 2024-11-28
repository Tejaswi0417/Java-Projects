package OOPs;
import java.util.Scanner;

public class PredictAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Age Prediction Game!");
        System.out.println("Follow the steps, and I'll predict your age.");

        System.out.println("\nStep 1: Think of your age (but don't tell me!).");
        System.out.println("Step 2: Multiply your age by 2.");
        System.out.print("Enter the result: ");
        int step2Result = scanner.nextInt();

        System.out.println("\nStep 3: Add 5 to the result.");
        System.out.print("Enter the new result: ");
        int step3Result = scanner.nextInt();

        System.out.println("\nStep 4: Multiply the result by 50.");
        System.out.print("Enter the final result: ");
        int step4Result = scanner.nextInt();

        System.out.println("\nStep 5: Add 1774 to the result.");
        System.out.print("Enter the final number: ");
        int finalResult = scanner.nextInt();

        System.out.println("\nStep 6: Subtract the year you were born (e.g., 1990): ");
        System.out.print("Enter the final result: ");
        int ageResult = scanner.nextInt();

        int age = ageResult % 100; // Extract the last two digits which represent the age
        System.out.println("\nLet me guess... Your age is: " + age + "!");
        System.out.println("Thanks for playing!");
        
        scanner.close();
    }
}
