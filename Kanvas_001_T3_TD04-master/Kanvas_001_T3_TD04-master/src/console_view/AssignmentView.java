package console_view;

import model.modulecontent.Assignment;

import static console_view.ViewUtil.makeUnderline;
import static console_view.ViewUtil.readNonBlankStringFromKeyboard;

public class AssignmentView {

    public static void display(Assignment assignment) {
        String underline = makeUnderline(assignment.getName());

        System.out.println(underline);
        System.out.println(assignment.getName());
        System.out.println(underline);
        System.out.println(assignment.getInstructions());
    }

    public static Assignment createAssignment() {
        String name = readNonBlankStringFromKeyboard("Name of Assignment");
        String instructions = readNonBlankStringFromKeyboard("Instructions for assignment");
        Assignment assignment = new Assignment(name);
        assignment.setInstructions(instructions);

        return assignment;
    }
}
