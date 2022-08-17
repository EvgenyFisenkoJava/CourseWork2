package pro.sky.coursework2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.coursework2.exceptions.WrongQuestionAmountRequested;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static pro.sky.coursework2.QuestionServiceConstants.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService questionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        examinerService = new ExaminerServiceImpl(questionServiceMock, mathQuestionServiceMock);
        when(questionServiceMock.getAll()).thenReturn(testServiceJavaAll);
        when(mathQuestionServiceMock.getAll()).thenReturn(testServiceMathAll);

    }

    @Test
    void getQuestion() {

        when(questionServiceMock.getRandomQuestion()).thenReturn(question1);
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(question3);
        assertThat(examinerService.getQuestion(2)).isEqualTo(testServiceAll);
    }

    @Test
    void shouldReturnIllegalArgumentsExceptionWhenEnterWrongAmount() {
        assertThrows(WrongQuestionAmountRequested.class, () -> examinerService.getQuestion(5));
    }
}