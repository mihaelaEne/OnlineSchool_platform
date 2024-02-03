package org.example.onlineschool_platform.Student.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    
}
