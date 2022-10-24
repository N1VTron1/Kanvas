package console_view;

import model.DiscussionReply;
import model.Section;
import model.Student;

public class DiscussionReplyView {
    public static void display(DiscussionReply reply) {
        System.out.println(reply.getStudent().toString());
        System.out.println(reply.getText());
    }
    /**
     * Creates a Discussion reply
     * <p>
     *     Displays a list of students for the user to select,
     *     then prompts them to write a one line reply
     * </p>
     *
     * @param section The Discussion Section
     * @return the reply for the Discussion
     * @author Benjamin Xu (bfx5005@psu.edu
     */
    public static DiscussionReply createDiscussionReply(Section section) {
        // TODO 02 - [console_view.DiscussionReplyView.createDiscussionReply] Choose the student
        /*
         * e.g.,
         *   .-------------------------------.
         *   | Student that will write reply |
         *   '-------------------------------'
         *   1) William H. Gates (whg5123@psu.edu)
         *   2) Paul G. Allen (pga123@psu.edu)
         *   3) Bart Simpson (bxs5987@psu.edu)
         *   4) Quit (or just hit Enter)
         *   Choice: 3
         */

        // HINT: This can be done in 2 lines.  Something in SectionView will help you
        SectionView sectionView = new SectionView(section);
        Student student = sectionView.chooseStudent("Student that will write reply");


        String text = ViewUtil.readNonBlankStringFromKeyboard("Reply (one line)");

        DiscussionReply reply = new DiscussionReply(student, text);

        return reply;
    }
}
