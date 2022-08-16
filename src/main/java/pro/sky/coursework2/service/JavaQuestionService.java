package pro.sky.coursework2.service;

import org.springframework.stereotype.Service;
import pro.sky.coursework2.Question;
import pro.sky.coursework2.QuestionService;

import java.util.*;
@Service
public class JavaQuestionService implements QuestionService {
    private Random random = new Random();
    private final Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {

        Question q = new Question(question, answer);
        questions.add(q);
        return q;
    }

    @Override
    public Question add(Question question) {

        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {

        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questions);
    }

    @Override
    public Question getRandomQuestion() {

        List<Question> list = new ArrayList<>(questions);
        Question question = list.get(random.nextInt(list.size()));
        return question;
    }
}
