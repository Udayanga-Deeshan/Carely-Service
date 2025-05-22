package com.pm.service;

import com.pm.dto.PatientRequestDTO;
import com.pm.dto.PatientResponseDTO;
import com.pm.exception.EmailAlreadyExistsException;
import com.pm.mapper.PatientMapper;
import com.pm.model.Patient;
import com.pm.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<PatientResponseDTO> getPatients(){
        List<Patient> patientEntityList = patientRepository.findAll();
        return patientEntityList.stream().map(PatientMapper::toDto).toList();

    }

    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO){
        if(patientRepository.existByEmail(patientRequestDTO.getEmail())){
                throw  new EmailAlreadyExistsException("A Patient with this email already exists" +patientRequestDTO.getEmail());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toModel(patientRequestDTO));
        return  PatientMapper.toDto(newPatient);
    }






}
