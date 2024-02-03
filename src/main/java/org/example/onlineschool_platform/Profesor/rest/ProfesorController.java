package org.example.onlineschool_platform.Profesor.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.onlineschool_platform.Profesor.dtos.CreateProfesorRequest;
import org.example.onlineschool_platform.Profesor.dtos.CreateProfesorResponse;
import org.example.onlineschool_platform.Profesor.dtos.UpdateProfesorRequest;
import org.example.onlineschool_platform.Profesor.model.Profesor;
import org.example.onlineschool_platform.Profesor.service.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Period;
import java.util.List;

@RestController
@RequestMapping("/api/online_school_platform")
@AllArgsConstructor
@Slf4j
public class ProfesorController {

    private ProfesorService profesorService;

    @GetMapping("/allProfesors")
    public ResponseEntity<List<Profesor>> getAllProf() {
        List<Profesor> profesors=profesorService.getAllProfesor();
        return new ResponseEntity<>(profesors, HttpStatus.OK);
    }

    @PostMapping("/createProfesor")
    public ResponseEntity<CreateProfesorResponse>addProf(@RequestBody CreateProfesorRequest createProfesorRequest){
        CreateProfesorResponse createProfesorResponse=profesorService.addProfesor(createProfesorRequest);
        return new ResponseEntity<>(createProfesorResponse,HttpStatus.CREATED);
    }

    @PutMapping("/updateProfesorPhone")
    public ResponseEntity<Void> updateProf(@RequestBody UpdateProfesorRequest updateProfesorRequest){
        profesorService.updateProfesor(updateProfesorRequest);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable long id){
        profesorService.deletepRrofesor(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
