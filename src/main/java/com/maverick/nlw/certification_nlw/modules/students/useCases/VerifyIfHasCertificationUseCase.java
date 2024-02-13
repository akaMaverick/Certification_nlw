package com.maverick.nlw.certification_nlw.modules.students.useCases;

import com.maverick.nlw.certification_nlw.modules.students.dto.VerifyCertificationDTO;
import org.springframework.stereotype.Service;

@Service
public class VerifyIfHasCertificationUseCase {

    public boolean execute(VerifyCertificationDTO dto) {
        if(dto.getEmail().equals("something") && dto.getTechnology().equals("Java")) {
            return true;
        }
        return false;
    }
}
