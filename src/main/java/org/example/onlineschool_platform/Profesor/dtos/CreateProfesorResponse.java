package org.example.onlineschool_platform.Profesor.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.onlineschool_platform.Profesor.model.Profesor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateProfesorResponse {
    private Profesor profesor;

    @Builder.Default
    private String message="Profesorul a fost creat cu succes";

}
