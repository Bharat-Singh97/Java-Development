import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("\n\n To-Do List App ");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");
            String str = scanner.nextLine();

            if(str.matches("[0-9]+")){
                choice = Integer.parseInt(str);
            }else{
                choice = 0;
            }

            

            switch (choice) {
                case 1:
                    System.out.print("\nEnter task to add: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println("\nTask added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("\nNo tasks to remove.");
                    } else {
                        System.out.println("\nEnter task number to remove:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                        int taskIndex = scanner.nextInt();
                        if (taskIndex > 0 && taskIndex <= tasks.size()) {
                            tasks.remove(taskIndex - 1);
                            System.out.println("\nTask removed successfully!");
                        } else {
                            System.out.println("\nInvalid task number.");
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("\nNo tasks available.");
                    } else {
                        System.out.println("\nYour Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nExiting... Have a great day!\n");
                    scanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice! Please try again.\n");
            }
        }
    }
}