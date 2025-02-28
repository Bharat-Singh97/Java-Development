import java.util.*;

class Account {
    private static int accountNumberCounter = 1000; 
    private int accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;

    public Account(String accountHolder, String accountType, double initialDeposit) {
        this.accountNumber = accountNumberCounter++;
        this.accountHolder = accountHolder;
        this.accountType = accountType;
        this.balance = initialDeposit;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        } else {
            System.out.println("\nInsufficient balance or invalid amount.\n");
            return false;
        }
    }

    public boolean transfer(Account toAccount, double amount) {
        if (withdraw(amount)) {
            toAccount.deposit(amount);
            System.out.println("Transferred " + amount + " to Account No: " + toAccount.getAccountNumber());
            return true;
        }
        return false;
    }

    public void displayDetails() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + balance);
    }
}

public class BankManagementSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Account> accounts = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n🏦 BANK MANAGEMENT SYSTEM 🏦");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    transferMoney();
                    break;
                case 5:
                    viewAccountDetails();
                    break;
                case 6:
                    System.out.println("Exiting... Thank you for using our bank! 😊");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("\nEnter Account Holder Name: ");
        scanner.nextLine();  
        String name = scanner.nextLine();
        System.out.print("Enter Account Type (Savings/Current): ");
        String type = scanner.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double deposit = scanner.nextDouble();

        Account newAccount = new Account(name, type, deposit);
        accounts.put(newAccount.getAccountNumber(), newAccount);
        System.out.println("✅ Account Created! Your Account Number is: " + newAccount.getAccountNumber());
    }

    private static void depositMoney() {
        System.out.print("\nEnter Account Number: ");
        int accNum = scanner.nextInt();
        if (accounts.containsKey(accNum)) {
            System.out.print("Enter Amount to Deposit: ");
            double amount = scanner.nextDouble();
            accounts.get(accNum).deposit(amount);
        } else {
            System.out.println(" Account Not Found!");
        }
    }

    private static void withdrawMoney() {
        System.out.print("\nEnter Account Number: ");
        int accNum = scanner.nextInt();
        if (accounts.containsKey(accNum)) {
            System.out.print("Enter Amount to Withdraw: ");
            double amount = scanner.nextDouble();
            accounts.get(accNum).withdraw(amount);
        } else {
            System.out.println(" Account Not Found!");
        }
    }

    private static void transferMoney() {
        System.out.print("\nEnter Your Account Number: ");
        int fromAccNum = scanner.nextInt();
        System.out.print("Enter Receiver Account Number: ");
        int toAccNum = scanner.nextInt();
        
        if (accounts.containsKey(fromAccNum) && accounts.containsKey(toAccNum)) {
            System.out.print("Enter Amount to Transfer: ");
            double amount = scanner.nextDouble();
            accounts.get(fromAccNum).transfer(accounts.get(toAccNum), amount);
        } else {
            System.out.println(" One or Both Accounts Not Found!");
        }
    }

    private static void viewAccountDetails() {
        System.out.print("\nEnter Account Number: ");
        int accNum = scanner.nextInt();
        if (accounts.containsKey(accNum)) {
            accounts.get(accNum).displayDetails();
        } else {
            System.out.println(" Account Not Found!");
        }
    }
}
