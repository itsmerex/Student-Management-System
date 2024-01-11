/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentManagementSystem;


public class courseData {
    private int courseId;
    private String course;
    private String description;
    private String degree;

    // Adjust the constructor to accept four arguments
    public courseData(int courseId, String course, String description, String degree) {
        this.courseId = courseId;
        this.course = course;
        this.description = description;
        this.degree = degree;
    }

    // Getter methods for each property
    public int getCourseId() {
        return courseId;
    }

    public String getCourse() {
        return course;
    }

    public String getDescription() {
        return description;
    }

    public String getDegree() {
        return degree;
    }
}
