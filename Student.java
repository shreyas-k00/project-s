

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {
    private int id;
    private String name;
    private List<String> courses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<String> getCourses() { return courses; }

    public void addCourse(String course) {
        courses.add(course);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Courses: " + courses;
    }
}
