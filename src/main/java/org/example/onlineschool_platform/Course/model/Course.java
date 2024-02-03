package org.example.onlineschool_platform.Course.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.example.onlineschool_platform.Student.model.Student;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Course")
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Course {
    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long id;


    @NotNull
    @Size(min = 3, message = "Numele trebuie sa contina minim 3 caractere!")
    private String name;

    @NotNull
    @Size(min = 3, message = "Departamentul trebuie sa contina minim 3 !")
    private String department;

//    @ManyToMany(mappedBy = "enrolledCourses", fetch = FetchType.EAGER)
//    @JsonBackReference
//    List<Student> students = new ArrayList<>();


}
