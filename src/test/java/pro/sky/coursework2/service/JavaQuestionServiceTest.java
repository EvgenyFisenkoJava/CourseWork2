package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.repository.JavaQuestionRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static pro.sky.coursework2.QuestionServiceConstants.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository javaQuestionRepository;
    @InjectMocks
    private JavaQuestionService questionService;

    @Test
    void add() {
        when(questionService.add(QUESTION1, ANSWER1)).thenReturn(question1);
        assertEquals(question1, questionService.add("question1", "answer1"));
    }

    @Test
    void testAdd() {
        when(javaQuestionRepository.add(question2)).thenReturn(question2);
        assertEquals(question2, questionService.add(question2));

    }

    @Test
    void remove() {
        when(javaQuestionRepository.remove(question1)).thenReturn(question1);
        assertEquals(question1, questionService.remove(question1));
    }

    @Test
    void getAll() {
        when(javaQuestionRepository.getAll()).thenReturn(testServiceJavaAll);
        assertEquals(testServiceJavaAll, questionService.getAll());
    }
}