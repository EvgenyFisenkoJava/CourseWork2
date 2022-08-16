package pro.sky.coursework2.service;

import org.junit.jupiter.api.Test;
import pro.sky.coursework2.Question;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.coursework2.QuestionServiceConstants.*;

class JavaQuestionServiceTest {
    private JavaQuestionService questionService;

    @Test
    void add() {
        questionService = new JavaQuestionService();
        Question questionExpected = new Question(QUESTION1, ANSWER1);
        assertEquals(questionExpected, questionService.add("question1", "answer1"));
    }

    @Test
    void testAdd() {
        Set<Question> testService = new HashSet<>(
                Arrays.asList(question2));
        Set<Question> testService2 = new HashSet<>(
                Arrays.asList(question1, question2));
        testService.add(question1);
        assertEquals(testService2, testService);
    }

    @Test
    void remove() {
        Set<Question> testService = new HashSet<>(
                Arrays.asList(question2));
        Set<Question> testService2 = new HashSet<>(
                Arrays.asList(question1, question2));

        testService2.remove(question1);
        assertEquals(testService, testService2);
    }

    @Test
    void getAll() {
        List<Question> testService = new ArrayList<>(
                Arrays.asList(question1, question2)
        );
        JavaQuestionService other = new JavaQuestionService();
        other.add(question1);
        other.add(question2);
        assertThat(other.getAll()).isEqualTo(testService);
    }
}