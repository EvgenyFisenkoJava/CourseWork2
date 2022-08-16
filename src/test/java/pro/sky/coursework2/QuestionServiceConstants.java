package pro.sky.coursework2;

import java.util.*;

public class QuestionServiceConstants {
    public static String QUESTION1 = "question1";
    public static String ANSWER1 = "answer1";
    public static String QUESTION2 = "question2";
    public static String ANSWER2 = "answer2";

    public static Question question1 = new Question(QUESTION1, ANSWER1);
    public static Question question2 = new Question(QUESTION2, ANSWER2);

    public final static Set<Question> testService = new HashSet<>(
            Arrays.asList(question2));
}
