package pro.sky.coursework2.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.QuestionService;
import pro.sky.coursework2.repository.JavaQuestionRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
@Qualifier("JavaQuestionService")
public class JavaQuestionService implements QuestionService {
    private Random random = new Random();
    private final JavaQuestionRepository javaQuestionRepository;

    public JavaQuestionService(JavaQuestionRepository javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {

        Question q = new Question(question, answer);
        javaQuestionRepository.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {


        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {

        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {

        List<Question> list = new ArrayList<>(javaQuestionRepository.getAll());
        Question question = list.get(random.nextInt(list.size()));
        return question;
    }
}
