import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            
            String n1 = "Rajesh";
            while (!n1.matches("\\d+(\\.\\d+)?")) {
                System.out.print("\nEnter first number: ");
                n1 = scanner.nextLine();
                if (!n1.matches("\\d+(\\.\\d+)?")) {
                    System.out.println("\nOnly numbers are allowed.\n");
                }
            }
            double num1 = Double.parseDouble(n1);

            
            char operator;
            while (true) {
                System.out.print("Enter an operator (+, -, *, /): ");
                operator = scanner.next().charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    break;
                } else {
                    System.out.println("\nInvalid operator!\n");
                }
            }

            
            scanner.nextLine(); 
            String n2 = "Rajesh";
            while (!n2.matches("\\d+(\\.\\d+)?")) {
                System.out.print("Enter second number: ");
                n2 = scanner.nextLine();
                if (!n2.matches("\\d+(\\.\\d+)?")) {
                    System.out.println("\nOnly numbers are allowed.\n");
                }
            }
            double num2 = Double.parseDouble(n2);

            
            double result = 0;
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("\nError! Division by zero is not allowed.");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            
            System.out.println("\nResult: " + result);
        } 
    }
}
