package pro.sky.coursework2.repository;

import org.springframework.stereotype.Repository;
import pro.sky.coursework2.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {

    private final Set<Question> questions = new HashSet<>();

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
}
