package com.maverick.nlw.certification_nlw.modules.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerCertification {

    private UUID id;
    private UUID certificationId;
    private UUID studentId;
    private UUID answerId;
    private boolean isCorrect;

}
