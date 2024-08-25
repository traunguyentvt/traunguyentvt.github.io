package nvntrau.com;

import java.util.Arrays;
import java.util.List;

public class Quiz {
    private final List<String> questions = Arrays.asList(
            "3, 1, 4, 1, 5",  // pi
            "1, 1, 2, 3, 5",  // fibonacci
            "1, 4, 9, 16, 25",  // squares
            "2, 3, 5, 7, 11",  // primes
            "1, 2, 4, 8, 16"   // powers of 2
    );
    private final List<Integer> answers = Arrays.asList(9, 8, 36, 13, 32);
    private int score = 0;
    private int currentQuestionIndex = 0;

    public String getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.size();
    }

    public void checkAnswer(int answer) {
        if (answer == answers.get(currentQuestionIndex)) {
            score++;
        }
    }

    public void nextQuestion() {
        currentQuestionIndex++;
    }

    public int getScore() {
        return score;
    }

    public int getTotalQuestions() {
        return questions.size();
    }
}