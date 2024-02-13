package com.maverick.nlw.certification_nlw.modules.students.controllers;

import com.maverick.nlw.certification_nlw.modules.students.dto.VerifyCertificationDTO;
import com.maverick.nlw.certification_nlw.modules.students.useCases.VerifyIfHasCertificationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private VerifyIfHasCertificationUseCase verifyIfHasCertificationUseCase;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyCertificationDTO verifyCertification) {
       var result = this.verifyIfHasCertificationUseCase.execute(verifyCertification);
       if(result) {
           return "Usuário já tem essa certificação.";
       }
        return "Usuario pode fazer a prova";
    }
}
