package casestudy.qn3;

import java.util.ArrayList;

public class Baby extends Nursery {


    public Baby(String classId) {
        super();
        this.classId = classId;
        this.className = "Baby Class";
        this.maxCapacity = 15;
        this.students = new ArrayList<>();
    }


    @Override
    public boolean enrollStudent(Student student) {

        if (assignedTeacher == null || !assignedTeacher.teacherRole.equals("Early Childhood Educator")) {
            System.out.println("Enrollment failed: Assigned teacher is not qualified for Baby Class.");
            return false;
        }


        if (student.age < 2 || student.age > 3) {
            System.out.println("Enrollment failed: Student age not allowed for Baby Class (must be 2–3 years old).");
            return false;
        }


        for (Student s : students) {
            if (s.studentId.equals(student.studentId)) {
                System.out.println("Enrollment failed: Duplicate student ID.");
                return false;
            }
        }


        if (students.size() >= maxCapacity) {
            System.out.println("Enrollment failed: Baby Class is already full.");
            return false;
        }


        students.add(student);
        student.registeredClass = this;
        return true;
    }


    @Override
    public void trackProgress() {
        System.out.println("Tracking progress in Baby Class: Focus on motor skills and play-based learning.");
    }


    @Override
    public void conductActivity(String activityName) {
        System.out.println("Conducting Baby Class activity: " + activityName);
        activities.add(activityName);
    }


    @Override
    public void generateClassReport() {
        System.out.println("\n--- Baby Class Report ---");
        System.out.println("Class ID: " + classId);
        System.out.println("Class Name: " + className);
        System.out.println("Assigned Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Number of Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
        System.out.println("Class Focus: Motor skills and play-based learning.");
    }
}

