import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("====================================");
        System.out.println("  WELCOME TO STUDENT GRADE TRACKER  ");
        System.out.println("====================================\n");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsIgnoreCase("done")) {
                break;
            }

            double grade = -1;
            while (true) {
                System.out.print("Enter grade for " + name + " (0 - 100): ");
                try {
                    grade = Double.parseDouble(scanner.nextLine());
                    if (grade >= 0 && grade <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid grade! Please enter a score between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a numerical grade.");
                }
            }

            names.add(name);
            grades.add(grade);
            System.out.println("Grade added successfully!\n");
        }

        if (grades.isEmpty()) {
            System.out.println("\nNo grades were entered. Exiting program.");
        } else {
            double total = 0;
            double highest = grades.get(0);
            double lowest = grades.get(0);

            for (double g : grades) {
                total += g;
                if (g > highest) highest = g;
                if (g < lowest) lowest = g;
            }

            double average = total / grades.size();

            System.out.println("\n====================================");
            System.out.println("        STUDENT GRADE SUMMARY       ");
            System.out.println("====================================");
            for (int i = 0; i < names.size(); i++) {
                System.out.printf("- %-15s : %.2f\n", names.get(i), grades.get(i));
            }
            System.out.println("------------------------------------");
            System.out.printf("Total Students : %d\n", names.size());
            System.out.printf("Average Grade  : %.2f\n", average);
            System.out.printf("Highest Grade  : %.2f\n", highest);
            System.out.printf("Lowest Grade   : %.2f\n", lowest);
            System.out.println("====================================");
        }

        scanner.close();
    }
}