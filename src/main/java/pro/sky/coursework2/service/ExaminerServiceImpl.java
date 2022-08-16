package pro.sky.coursework2.service;

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
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestion(int amount) {
        Set<Question> examQuestions = new HashSet<>();
        if (amount > questionService.getAll().size() || amount <= 0) {
            throw new WrongQuestionAmountRequested();
        }
        while (examQuestions.size() < amount) {
            examQuestions.add(questionService.getRandomQuestion());
        }
        return examQuestions;
    }
}
