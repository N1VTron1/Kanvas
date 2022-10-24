package model;


public class QuizAnswer {
    final String text;
    final boolean isCorrect;

    public QuizAnswer(String text, boolean isCorrect) {
        this.text = text;
        this.isCorrect = isCorrect;
    }

    public boolean getIsCorrect() {
        return isCorrect;
    }
}
