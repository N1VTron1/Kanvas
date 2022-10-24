package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.Module;
import model.Section;
import model.modulecontent.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static console_view.ViewUtil.readNonBlankStringFromKeyboard;

public class ModuleView {
    public static void display(Module module) {

        Menu menu = new Menu(module.getName());
        for (IContent content : module.getContents()) {
            String contentType = content.getContentType();
            String contentDesc = content.getShortDescription();
            MenuChoice choice = new MenuChoice(String.format("%s: %s", contentType, contentDesc));
            menu.addMenuChoice(choice);
            choice.setObject(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);
        MenuChoice choice;
        do {
            choice = display.displayAndChoose();
            System.out.printf("You chose: %s%n", choice.getText());
            System.out.printf("Nothing else will happen here");
        } while (choice != menu.getMenuChoiceQuit());
    }

    /**
     * Creates a module.
     * <p>
     *     Allows the user to name the module and add content from a class section to create a module.
     * </p>
     * @param section The class section
     * @return A module containing content for the class sectionMod
     */
    public static Module createModule(Section section) {
        String name = readNonBlankStringFromKeyboard("Name of Module");
        Module module = new Module(name);

        Menu menu = new Menu(String.format("Add Content to '%s'", name));

        List<IContent> allContent = new ArrayList<>();
        // TODO 05 - [console_view.ModuleView.createModule] Populate all content from this section
        //   This should include (in this order): announcements, discussions, assignment, quizzes

        Iterable<Announcement> announcements = section.getAnnouncements();
        Iterable<Discussion> discussions = section.getDiscussions();
        Iterable<Assignment> assignments = section.getAssignments();
        Iterable<Quiz> quizzes = section.getQuizzes();

        announcements.forEach(allContent::add);
        discussions.forEach(allContent::add);
        assignments.forEach(allContent::add);
        quizzes.forEach(allContent::add);

        for (IContent content : allContent) {
            String contentType = content.getContentType();
            String contentDesc = content.getShortDescription();
            MenuChoice choice = new MenuChoice(String.format("%s: %s", contentType, contentDesc));
            choice.setObject(content);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice;
        while (true) {
            choice = display.displayAndChoose();
            if (choice == menu.getMenuChoiceQuit()) break;
            module.addContent((IContent) choice.getObject());
        }

        return module;
    }
}
