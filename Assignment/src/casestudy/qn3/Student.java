package casestudy.qn3;

public class Student {
    public String studentId;
    public String studentName;
    public int age;
    public String guardianName;
    public Nursery registeredClass;

    public Student(String studentId, String studentName, int age, String guardianName) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.guardianName = guardianName;
    }
}

