package pro.sky.coursework2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class QuestionServiceConstants {
    public static String QUESTION1 = "question1";
    public static String ANSWER1 = "answer1";
    public static String QUESTION2 = "question2";
    public static String ANSWER2 = "answer2";
    public static String QUESTION3 = "1+1";
    public static String ANSWER3 = "2";
    public static String QUESTION4 = "2+2";
    public static String ANSWER4 = "4";

    public static Question question1 = new Question(QUESTION1, ANSWER1);
    public static Question question2 = new Question(QUESTION2, ANSWER2);
    public static Question question3 = new Question(QUESTION3, ANSWER3);
    public static Question question4 = new Question(QUESTION4, ANSWER4);

    public final static Set<Question> testServiceJavaAll = new HashSet<>(
            Arrays.asList(question1, question2));
    public final static Set<Question> testServiceMathAll = new HashSet<>(
            Arrays.asList(question3, question4));
    public final static Set<Question> testServiceAll = new HashSet<>(
            Arrays.asList(question1, question3));
}
