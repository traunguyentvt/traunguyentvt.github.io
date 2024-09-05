package nvntrau.com;

import java.util.Arrays;
import java.util.List;

public class Quiz {
    private final List<String> questions = Arrays.asList(
            "3, 1, 4, 1, 5",       // pi
            "1, 1, 2, 3, 5",      // fibonacci
            "1, 4, 9, 16, 25",   // squares
            "2, 3, 5, 7, 11",   // primes
            "1, 2, 4, 8, 16"   // powers of 2
    );

    public String getHint() {
        switch (currentQuestionIndex) {
            case 0:
                return "It might be the Pi numbers";
            case 1:
                return "It might be the Fibonacci numbers";
            case 2:
                return "It might be the Squares numbers";
            case 3:
                return "It might be the Primes numbers";
            default:
                return "It might be the Powers of 2 numbers";
        }
    }

    private final List<Integer> answers = Arrays.asList(9, 8, 36, 13, 32);

    private int score = 0;
    private int currentQuestionIndex = 0;
    public final int maxTryAgain = 3;
    public int currentTryAgain = 0;

    public String getCurrentQuestion() {
        if (currentQuestionIndex < questions.size()) {
            return questions.get(currentQuestionIndex);
        }
        return null;
    }

    public boolean hasNextQuestion() {
        return currentQuestionIndex < questions.size();
    }

    public boolean checkAnswer(int answer) {
        return answer == answers.get(currentQuestionIndex);
    }

    public void getNextQuestion() {
        if (currentTryAgain == 0) {
            score += 10;
        }
        if (currentTryAgain == 1) {
            score += 5;
        }
        if (currentTryAgain == 2) {
            score += 2;
        }
        currentTryAgain = 0;
        currentQuestionIndex++;
    }

    public int getScore() {
        return score;
    }

    public int getTotalScores() {
        return questions.size() * 10;
    }

    public String getGrade() {
        if (score >= 45) {
            return "Your grade is A";
        }
        if (score >= 35) {
            return "Your grade is B";
        }
        if (score >= 25) {
            return "Your grade is C";
        }
        return "Your grade is NC";
    }
}
