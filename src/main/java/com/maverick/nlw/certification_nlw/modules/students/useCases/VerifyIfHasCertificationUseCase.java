package com.maverick.nlw.certification_nlw.modules.students.useCases;

import com.maverick.nlw.certification_nlw.modules.students.dto.VerifyCertificationDTO;
import com.maverick.nlw.certification_nlw.modules.students.repositorie.CertificationStudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VerifyIfHasCertificationUseCase {

    private CertificationStudentRepository certificationStudentRepository;

    public boolean execute(VerifyCertificationDTO dto) {
        var result = certificationStudentRepository.findByStudentEmailAndTechnology(dto.getEmail(), dto.getTechnology());
        if(!result.isEmpty()) {
            return true;
        }
        return false;
    }
}
