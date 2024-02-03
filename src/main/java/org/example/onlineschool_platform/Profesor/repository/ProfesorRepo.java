package org.example.onlineschool_platform.Profesor.repository;

import org.example.onlineschool_platform.Profesor.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepo extends JpaRepository<Profesor, Long> {

    @Query("select p from Profesor p where p.fullName= ?1")
    Optional<Profesor> findProfesorByFullName(String fullName);

    @Query("select p from Profesor p where p.email= ?1 and p.password= ?2")
    Optional<Profesor>findProfesorByEmailAndPassWord(String fullName);
}
