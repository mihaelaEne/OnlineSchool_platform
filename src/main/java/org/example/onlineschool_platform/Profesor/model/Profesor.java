package org.example.onlineschool_platform.Profesor.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "Profesor")
@Table(name = "profesor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Profesor {

    @Id
    @SequenceGenerator(name = "profesor_sequence", sequenceName = "profesor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_sequence")
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

}
