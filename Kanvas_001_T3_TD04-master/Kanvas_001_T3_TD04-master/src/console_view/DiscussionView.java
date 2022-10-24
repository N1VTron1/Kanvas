package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuAction;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.DiscussionReply;
import model.Section;
import model.modulecontent.Discussion;

public class DiscussionView {
    final MaintMenu maintMenu = new MaintMenu("Reply Maintenance");

    private final Discussion discussion;
    private final Section section;

    public DiscussionView(Section section, Discussion discussion) {
        this.section = section;
        this.discussion = discussion;
        maintMenu.mcList.setMenuAction(listDiscussionReplies);
        maintMenu.mcCreate.setMenuAction(createDiscussionReply);
        maintMenu.mcDelete.setMenuAction(deleteDiscussionReply);
    }

    private final MenuAction listDiscussionReplies = new MenuAction() {
        @Override
        public void execute() {
            while (true) {
                DiscussionReply reply = chooseDiscussionReply("Replies");
                if (reply == null) break;
                DiscussionReplyView.display(reply);
            }
        }

    };
    private final MenuAction createDiscussionReply = new MenuAction() {
        @Override
        public void execute() {
            DiscussionReply discussionReply = DiscussionReplyView.createDiscussionReply(section);
            discussion.addReply(discussionReply);
        }
    };

    /**
     * Deletes a Discussion reply
     * <p>
     *     Displays a list of replies to a discussion that the user can choose from
     *     then deletes it from the discussion
     * </p>
     *
     * @author Benjamin Xu (bfx5005@psu.edu
     */
    private final MenuAction deleteDiscussionReply = new MenuAction() {
        @Override
        public void execute() {
            // TODO 03 - [console_view.DiscussionView.deleteDiscussionReply] Choose the reply, and delete it from discussion
            //   This should only take about 5 lines
            DiscussionReply discussionReply;
            do {
                discussionReply = chooseDiscussionReply("Delete Discussion Reply");
                if (discussionReply != null) {
                    discussion.deleteDiscussionReply(discussionReply);
                }
            } while (discussionReply != null);

        }
    };


    public static Discussion createDiscussion() {
        String title = ViewUtil.readNonBlankStringFromKeyboard("Title");
        Discussion discussion = new Discussion(title);

        String text = ViewUtil.readNonBlankStringFromKeyboard("Text (one line only)");
        discussion.setText(text);

        return discussion;
    }

    /**
     * Displays the discussion forum
     * <p>
     *     Displays the discussion title and description. After viewing the forum, the user can choose
     *     to enter a reply or exit the Reply Maintenance menu.
     * </p>
     * @author Nivaldo Acevedo (naa5453@psu.edu)
     */
    public void display() {
        // TODO 04 - [console_view.DiscussionView.display] Display discussion as shown in output
        /*
         * e.g.,
         * Discuss code that needs to be structured better with methods
         * ------------------------------------------------------------
         *
         * Given what was presented today, point out what parts of the code can be improved by creating methods.
         */

        System.out.println(discussion.getTitle());
        System.out.println("------------------------------------------------------------");
        System.out.println(discussion.getText());

        MenuChoice choice = null;
        while (true) {
            choice = maintMenu.display.displayAndChoose();
            if (choice == maintMenu.mcQuit) break;
        }

    }

    public DiscussionReply chooseDiscussionReply(String title) {
        Menu menu = new Menu(title);
        for (DiscussionReply reply : discussion.getReplies()) {
            MenuChoice choice = new MenuChoice(reply.toString());
            choice.setObject(reply);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);
        MenuChoice choice = display.displayAndChoose();
        DiscussionReply reply = null;
        if (choice != menu.getMenuChoiceQuit()) {
            reply = (DiscussionReply) (choice.getObject());
        }

        return reply;
    }

}
