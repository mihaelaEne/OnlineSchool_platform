package org.example.onlineschool_platform.Profesor.service;

import jakarta.transaction.Transactional;
import org.example.onlineschool_platform.Profesor.dtos.CreateProfesorRequest;
import org.example.onlineschool_platform.Profesor.dtos.CreateProfesorResponse;
import org.example.onlineschool_platform.Profesor.dtos.UpdateProfesorRequest;
import org.example.onlineschool_platform.Profesor.exception.ErrException;
import org.example.onlineschool_platform.Profesor.exception.NoUpdateException;
import org.example.onlineschool_platform.Profesor.exception.ProfesorDoesntExistException;
import org.example.onlineschool_platform.Profesor.exception.ProfesorExistException;
import org.example.onlineschool_platform.Profesor.model.Profesor;
import org.example.onlineschool_platform.Profesor.repository.ProfesorRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProfesorService {

    private ProfesorRepo profesorRepo;
    public List<Profesor> getAllProfesor(){
        List<Profesor>all=profesorRepo.findAll();
        if(all.size()==0){
            throw new ErrException();
        }
        return all;
    }


    @Transactional

    public CreateProfesorResponse addProfesor(CreateProfesorRequest createProfesorRequest){

        Optional<Profesor> profesorByName=profesorRepo.findProfesorByFullName(createProfesorRequest.getFullName());

        if(profesorByName.isPresent()){
            throw  new ProfesorExistException();
        }

        Profesor profesor=Profesor.builder()
                .fullName(createProfesorRequest.getFullName())
                .email(createProfesorRequest.getEmail())
                .password(createProfesorRequest.getPassword())
                .phone(createProfesorRequest.getPhone())
                .build();


        Profesor profesor1=profesorRepo.saveAndFlush(profesor);

        return CreateProfesorResponse.builder().profesor(profesor1).build();
    }

    @Transactional
    public void deletepRrofesor(long id){
        Optional<Profesor>profesor=profesorRepo.findById(id);
        if(profesor.isPresent()){
            profesorRepo.delete(profesor.get());
        }else{
            throw new ProfesorDoesntExistException();
        }
    }

    @Transactional
    public void updateProfesor(UpdateProfesorRequest updateProfesorRequest){
        Optional<Profesor>profesorOptional=profesorRepo.findProfesorByEmailAndPassWord(updateProfesorRequest.getFullName());
        if(profesorOptional.isPresent()){
            Profesor profesor=profesorOptional.get();


            if(!updateProfesorRequest.getPhone().equals("")){
                profesor.setPhone(updateProfesorRequest.getPhone());
            }

            else {
                throw new NoUpdateException();
            }
        }
    }


}
