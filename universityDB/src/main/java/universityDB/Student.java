package universityDB;

public class Student {
    private int id;
    private String name;
    private String major;

    // Constructor, getters, and setters
    public Student(int id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMajor() {
        return major;
    }
}
