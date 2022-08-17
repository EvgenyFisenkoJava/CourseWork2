package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.ExaminerService;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.QuestionService;
import pro.sky.coursework2.exceptions.WrongQuestionAmountRequested;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private Random random;
    private QuestionService questionService1;
    private QuestionService questionService2;

    public ExaminerServiceImpl(@Qualifier("JavaQuestionService") QuestionService questionService1,
                               @Qualifier("MathQuestionService") QuestionService questionService2) {
        this.questionService1 = questionService1;
        this.questionService2 = questionService2;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> examQuestions = new HashSet<>();
        if (amount > questionService1.getAll().size() + questionService2.getAll().size() || amount <= 0) {
            throw new WrongQuestionAmountRequested();
        }
        while (examQuestions.size() < amount) {
            examQuestions.add(questionService1.getRandomQuestion());
            examQuestions.add(questionService2.getRandomQuestion());
        }
        return examQuestions;
    }
}
