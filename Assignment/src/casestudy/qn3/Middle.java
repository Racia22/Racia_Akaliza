package casestudy.qn3;

import java.util.ArrayList;

public class Middle extends Nursery {


    public Middle(String classId) {
        this.classId = classId;
        this.className = "Middle Class";
        this.maxCapacity = 20;
        this.students = new ArrayList<>();
    }


    @Override
    public boolean enrollStudent(Student student) {
        // Check age
        if (student.age < 3 || student.age > 4) {
            System.out.println("Enrollment failed: Student age not allowed for Middle Class (must be 3–4 years old).");
            return false;
        }


        for (Student s : students) {
            if (s.studentId.equals(student.studentId)) {
                System.out.println("Enrollment failed: Duplicate student ID.");
                return false;
            }
        }


        if (students.size() >= maxCapacity) {
            System.out.println("Enrollment failed: Middle Class is already full.");
            return false;
        }


        students.add(student);
        student.registeredClass = this;
        return true;
    }

    @Override
    public void trackProgress() {
        System.out.println("Tracking progress in Middle Class: Focus on language development, counting, and storytelling.");
    }

    @Override
    public void conductActivity(String activityName) {
        System.out.println("Conducting Middle Class activity: " + activityName);
        activities.add(activityName);
    }

    @Override
    public void generateClassReport() {
        System.out.println("\n--- Middle Class Report ---");
        System.out.println("Class ID: " + classId);
        System.out.println("Class Name: " + className);
        System.out.println("Assigned Teacher: " + (assignedTeacher != null ? assignedTeacher.teacherName : "None"));
        System.out.println("Number of Students: " + students.size());
        System.out.println("Activities Conducted: " + activities);
        System.out.println("Class Focus: Language development, basic counting, and storytelling.");
    }
}

