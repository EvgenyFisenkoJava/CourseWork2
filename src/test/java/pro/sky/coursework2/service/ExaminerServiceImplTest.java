package pro.sky.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exceptions.WrongQuestionAmountRequested;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.coursework2.QuestionServiceConstants.question2;
import static pro.sky.coursework2.QuestionServiceConstants.testService;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        when(questionServiceMock.getAll()).thenReturn(testService);
    }

    @Test
    void getQuestion() {
        when(questionServiceMock.getRandomQuestion()).thenReturn(question2);
        assertEquals(testService, examinerService.getQuestion(1));
    }

    @Test
    void shouldReturnIllegalArgumentsExceptionWhenEnterWrongAmount() {
        assertThrows(WrongQuestionAmountRequested.class, () -> examinerService.getQuestion(2));
    }
}