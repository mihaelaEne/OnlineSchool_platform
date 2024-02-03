package org.example.onlineschool_platform.Profesor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateProfesorRequest {
    private String fullName="";
    private String email="";
    private String password="";
    private String phone="";
    
}
