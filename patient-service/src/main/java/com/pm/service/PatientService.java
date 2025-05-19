package com.pm.service;

import com.pm.dto.PatientResponseDTO;
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
}
