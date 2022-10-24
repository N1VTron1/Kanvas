package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.QuizQuestion;
import model.modulecontent.Quiz;

import static console_view.ViewUtil.makeUnderline;
import static console_view.ViewUtil.readNonBlankStringFromKeyboard;

public class QuizView {

    public static void display(Quiz quiz) {
        String underline = makeUnderline(quiz.getName());

        System.out.println(underline);
        System.out.println(quiz.getName());
        System.out.println(underline);

        int num = 0;
        for (QuizQuestion question : quiz.getQuestions()) {
            num++;
            QuizQuestionView.display(num, question);
        }
    }


    public static Quiz createQuiz() {
        String name = readNonBlankStringFromKeyboard("Name of Quiz");
        Quiz quiz = new Quiz(name);

        Menu menu = new Menu("Create Question");
        MenuChoice mcCreateAnother = menu.addMenuChoice("Create Another");
        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice;
        do {
            choice = display.displayAndChoose();
            if (choice == mcCreateAnother) {
                quiz.addQuestion(QuizQuestionView.createQuizQuestion());
            }
        } while (choice != menu.getMenuChoiceQuit());

        return quiz;
    }
}
