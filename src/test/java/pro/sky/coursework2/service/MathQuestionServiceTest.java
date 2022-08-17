package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.repository.MathQuestionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static pro.sky.coursework2.QuestionServiceConstants.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository mathQuestionRepository;
    @InjectMocks
    private MathQuestionService questionService;

    @Test
    void add() {
        when(questionService.add(QUESTION1, ANSWER1)).thenReturn(question1);
        assertEquals(question1, questionService.add("question1", "answer1"));
    }

    @Test
    void testAdd() {
        when(mathQuestionRepository.add(question2)).thenReturn(question2);
        assertEquals(question2, questionService.add(question2));
    }

    @Test
    void remove() {
        when(mathQuestionRepository.remove(question1)).thenReturn(question1);
        assertEquals(question1, questionService.remove(question1));
    }

    @Test
    void getAll() {
        when(mathQuestionRepository.getAll()).thenReturn(testServiceAll);
        assertEquals(testServiceAll, questionService.getAll());
    }
}