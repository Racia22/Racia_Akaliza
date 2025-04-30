package casestudy.qn3;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            String tname = getValidName(scanner, "Enter teacher name: ");
            String tid = getValidID(scanner, "Enter teacher ID: ");
            System.out.print("Enter teacher role: ");
            String role = scanner.nextLine();
            Teacher teacher = new Teacher(tid, tname, role);


            System.out.println("Select class type: 1. Baby 2. Middle 3. Top");
            int type = Integer.parseInt(scanner.nextLine());
            Nursery nurseryClass = null;

            if (type == 1) {
                nurseryClass = new Baby("B001");
            } else if (type == 2) {
                nurseryClass = new Middle("M001");
            } else if (type == 3) {
                nurseryClass = new Top("T001");
            } else {
                System.out.println("Invalid class type selected. Exiting.");
                return;
            }


            nurseryClass.assignedTeacher = teacher;
            teacher.assignedClass = nurseryClass;


            System.out.print("How many students to enroll? ");
            int n = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < n; i++) {
                System.out.println("Enter student " + (i + 1) + " details");
                String sid = getValidID(scanner, "ID: ");
                String sname = getValidName(scanner, "Name: ");
                System.out.print("Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                String guardian = getValidName(scanner, "Guardian name: ");

                Student s = new Student(sid, sname, age, guardian);
                boolean enrolled = nurseryClass.enrollStudent(s);
                if (!enrolled) {

                    System.out.println("Enrollment failed for student " + sname);
                } else {
                    System.out.println("Enrollment successful for student " + sname);
                }
            }


            System.out.print("Enter activity name: ");
            String activity = scanner.nextLine();
            nurseryClass.conductActivity(activity);


            nurseryClass.trackProgress();


            nurseryClass.generateClassReport();

            scanner.close();
        }


        public static String getValidName(Scanner scanner, String prompt) {
            while (true) {
                System.out.print(prompt);
                String input = scanner.nextLine();
                if (input.matches("[a-zA-Z ]+")) {
                    return input;
                } else {
                    System.out.println("Invalid input: names must be letters only.");
                }
            }
        }


        public static String getValidID(Scanner scanner, String prompt) {
            while (true) {
                System.out.print(prompt);
                String input = scanner.nextLine();
                if (input.matches("[a-zA-Z][a-zA-Z0-9]*")) {
                    return input;
                } else {
                    System.out.println("Invalid input: ID must start with a letter and contain only letters or digits.");
                }
            }
        }
    }