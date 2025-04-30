package casestudy.qn3;

import java.util.ArrayList;

public abstract class Nursery {
    public String classId;
    public String className;
    public int maxCapacity;
    public Teacher assignedTeacher;
    public ArrayList<Student> students = new ArrayList<>();
    public ArrayList<String> activities = new ArrayList<>();
    public String progressNote = "";

    public Nursery(String classId, String className, int maxCapacity) {
        this.classId = classId;
        this.className = className;
        this.maxCapacity = maxCapacity;
    }

    public Nursery() {

    }

    public abstract boolean enrollStudent(Student student);
    public abstract void trackProgress();
    public abstract void conductActivity(String activityName);
    public abstract void generateClassReport();
}


