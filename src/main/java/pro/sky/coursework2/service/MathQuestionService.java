package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.QuestionService;
import pro.sky.coursework2.repository.MathQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
@Qualifier("MathQuestionService")
public class MathQuestionService implements QuestionService {
    private Random random = new Random();
    private final MathQuestionRepository mathQuestionRepository;

    public MathQuestionService(MathQuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question q = new Question(question, answer);
        mathQuestionRepository.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {

        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {

        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> list = new ArrayList<>(mathQuestionRepository.getAll());
        Question question = list.get(random.nextInt(list.size()));
        return question;
    }
}
