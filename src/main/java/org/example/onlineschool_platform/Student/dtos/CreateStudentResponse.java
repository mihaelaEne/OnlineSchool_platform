package org.example.onlineschool_platform.Student.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineschool_platform.Student.model.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentResponse {
    private Student student;

    @Builder.Default
    private String message="Studentul a fost creat cu succes";

}
