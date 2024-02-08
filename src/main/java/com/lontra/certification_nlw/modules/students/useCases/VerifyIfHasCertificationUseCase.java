package com.lontra.certification_nlw.modules.students.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lontra.certification_nlw.modules.students.dto.VerifyHasCertificationDTO;
import com.lontra.certification_nlw.modules.students.repositories.CertificationStudentsRepository;

@Service
public class VerifyIfHasCertificationUseCase {

    @Autowired
    private CertificationStudentsRepository certificationStudentsRepository;

    public boolean execute( VerifyHasCertificationDTO dto ) {
        var result = this.certificationStudentsRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()) {
            return true;
        }
        return false;
    }
}
