package casestudy.qn3;

import java.util.ArrayList;

public class Top extends Nursery {


    public Top(String classId) {
        this.classId = classId;
        this.className = "Top Class";
        this.maxCapacity = 25;
        this.students = new ArrayList<>();
    }


    @Override
    public boolean enrollStudent(Student student) {

        if (student.age < 4 || student.age > 5) {
            System.out.println("Enrollment failed: Student age not allowed for Top Class (must be 4–5 years old).");
            return false;
        }


        for (Student s : students) {
            if (s.studentId.equals(student.studentId)) {
                System.out.println("Enrollment failed: Duplicate student ID.");
                return false;
            }
        }


        if (students.size() >= maxCapacity) {
            System.out.println("Enrollment failed: Top Class is already full.");
            return false;
        }


        students.add(student);
        student.registeredClass = this;
        return true;
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking progress in Top Class: Preparing for primary school with reading, writing, and arithmetic.");
        System.out.println("Assessment: Conducted every term.");
    }

    @Override
    public void conductActivity(String activityName) {
        System.out.println("Conducting Top Class activity: " + activityName);
        activities.add(activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Top Class Report ---");
        System.out.println("Class ID: " + classId);
        System.out.println("Class Name: " + className);
        System.out.println("Assigned Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Number of Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
        System.out.println("Class Focus: Reading, writing, arithmetic.");
        System.out.println("Assessments: Conducted every term.");
    }
}


