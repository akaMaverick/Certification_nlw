package com.maverick.nlw.certification_nlw.modules.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificationStudent {

    private UUID id;
    private UUID studentId;
    private String technology;
    private int grate;
    List<AnswerCertification> answerCertificationList;
}
