package console_view;

import model.QuizQuestion;

import static console_view.ViewUtil.readNonBlankStringFromKeyboard;
import static console_view.ViewUtil.userInputInt;

public class QuizQuestionView {

    public static QuizQuestion createQuizQuestion() {
        /*
         * Prompt the user for the quiz text and point value.
         * We're not dealing with the answers in this deliverable
         * Create the QuizQuestion object, and return it.
         *
         * This can be done in about 4 lines.  If you find you're doing more
         * than that, look around for an existing utility method that will make
         * it easier.
         */
        String text = readNonBlankStringFromKeyboard("What is the question?");
        int points = userInputInt("How many points is it worth?");
        QuizQuestion question = new QuizQuestion(text, points);
        return question;
    }

    public static void display(int num, QuizQuestion question) {
        System.out.printf("%s) [%d pts] - %s%n", num, question.getPoints(), question.getText());
    }
}
