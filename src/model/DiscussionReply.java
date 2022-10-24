package model;

public class DiscussionReply {
    private Student student;
    private String text;

    private DiscussionReply() {

    }

    public DiscussionReply(Student student, String text) {
        this.student = student;
        this.text = text;
    }

    public Student getStudent() {
        return student;
    }

    public String getText() {
        return text;
    }

    /**
     * Converting the student object to a string upon selection.
     *<p>
     *
     * Upon selection in the menu, this method will take the student object and convert it
     * to a string. While also collecting their reply in the menu, after which
     * will be displayed.
     * <p>
     *
     * @return the student, their details, and their reply.
     * @author David Terrell (dvt5367@psu.edu)
     */
    public String toString() {
        // TODO 09 - [model.DiscussionReply.toString] Write this to match the output
        /*
         * e.g., So a reply looks like this in a menu: 
         *  .--------------.
         *  | Delete Reply |
         *  '--------------'
         *  1) William H. Gates (whg5123@psu.edu) - "The main ..."
         *  2) Paul G. Allen (pga123@psu.edu) - "There are..."
         *  3) Quit (or just hit Enter)
         *  Choice: 1
         *  William H. Gates (whg5123@psu.edu)
         *  The main method needs to separate into other methods
         */
        // NOTE - this task is independent from menu objects.  You will not be doing ANYTHING with menus here.
        String student, studentReply;

        student = getStudent().toString();
        studentReply = getText();


        return student + " - "+ studentReply;
    }
}
