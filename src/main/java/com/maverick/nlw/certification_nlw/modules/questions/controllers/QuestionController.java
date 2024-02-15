package com.maverick.nlw.certification_nlw.modules.questions.controllers;

import com.maverick.nlw.certification_nlw.modules.questions.dto.AlternativeResultDTO;
import com.maverick.nlw.certification_nlw.modules.questions.dto.QuestionResultDTO;
import com.maverick.nlw.certification_nlw.modules.questions.entities.Alternatives;
import com.maverick.nlw.certification_nlw.modules.questions.entities.Question;
import com.maverick.nlw.certification_nlw.modules.questions.repositories.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {

    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResultDTO> findByTechnology(@PathVariable String technology) {
        var result = questionRepository.findByTechnology(technology);
        var toMap = result.stream().map(question -> mapQuestionToDto(question)).collect(Collectors.toList());

        return toMap;
    }

    static QuestionResultDTO mapQuestionToDto(Question question) {
        var questionResultDto = QuestionResultDTO.builder()
                .id(question.getId())
                .technology(question.getTechnology())
                .description(question.getDescription()).build();

        List<AlternativeResultDTO> alternativeResultDTOS = question.getAlternatives().stream()
                .map(alternative -> mapAlternativeDto(alternative)).collect(Collectors.toList());

        questionResultDto.setAlternatives(alternativeResultDTOS);
        return questionResultDto;
    }

    static AlternativeResultDTO mapAlternativeDto(Alternatives alternativesResultDto) {
        return AlternativeResultDTO.builder()
                .id(alternativesResultDto.getId())
                .description(alternativesResultDto.getDescription()).build();
    }
}
