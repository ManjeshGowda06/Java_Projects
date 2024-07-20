package java_projects_oops;

import java.util.ArrayList;
import java.util.List;

class Student {
    private String studentId;
    private String name;
    private List<String> enrolledCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<String> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void enrollInCourse(String course) {
        enrolledCourses.add(course);
        System.out.println(name + " has enrolled in the course: " + course);
    }

    public void displayStudentDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Enrolled Courses: " + enrolledCourses);
    }
}

class Course {
    private String courseId;
    private String courseName;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
}

class StudentManagementSystem {
    private List<Student> students;
    private List<Course> courses;

    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course added successfully.");
    }

    public void enrollStudentInCourse(String studentId, String courseId) {
        Student student = findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            student.enrollInCourse(course.getCourseName());
        } else {
            System.out.println("Student or course not found.");
        }
    }

    public void displayStudentDetails(String studentId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            student.displayStudentDetails();
        } else {
            System.out.println("Student not found.");
        }
    }

    private Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

    private Course findCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }
}

public class Student_management_system{
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        // Adding students
        Student student1 = new Student("1", "John Doe");
        Student student2 = new Student("2", "Jane Doe");

        sms.addStudent(student1);
        sms.addStudent(student2);

        // Adding courses
        Course course1 = new Course("C1", "Java Programming");
        Course course2 = new Course("C2", "Database Management");

        sms.addCourse(course1);
        sms.addCourse(course2);

        // Enrolling students in courses
        sms.enrollStudentInCourse("1", "C1");
        sms.enrollStudentInCourse("2", "C2");

        // Displaying student details
        sms.displayStudentDetails("1");
        sms.displayStudentDetails("2");
    }
}