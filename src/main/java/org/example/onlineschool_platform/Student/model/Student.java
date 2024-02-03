package org.example.onlineschool_platform.Student.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.example.onlineschool_platform.Course.model.Course;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Student")
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;

    @Column(name="fullName")
    @NotBlank(message="Numele si prenumele sunt necesare")
    private String fullName;

    @Column(name="email")
    @NotBlank(message="Email-ul este necesar")
    private String email;

    @Column(name="password")
    @NotBlank(message="Parola este necesara")
    private String password;

    @Column(name="phone")
    @NotBlank(message="Telefonul este necesar")
    private String phone;


//    @JsonManagedReference
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "enrolled_coruse", joinColumns = {@JoinColumn(name = "student_id")},
//            inverseJoinColumns = {@JoinColumn(name = "course_id")})
//    @Builder.Default
//    private List<Course> enrolledCourses=new ArrayList<>();
//
//    public void addCourse(Course course){
//        enrolledCourses.add(course);
//    }
//
//    public void removeCourse(Course course){
//        enrolledCourses.remove(course);
//    }
}
