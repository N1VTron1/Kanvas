package console_view;

import model.modulecontent.Announcement;

import static console_view.ViewUtil.makeUnderline;
import static console_view.ViewUtil.readNonBlankStringFromKeyboard;

public class AnnouncementView {

    public static void display(Announcement announcement) {
        String underline = makeUnderline(announcement.getTopic());

        System.out.println(underline);
        System.out.println(announcement.getTopic());
        System.out.println(underline);
        System.out.println(announcement.getText());
    }

    /**
     * Creates an Announcement
     * <p>
     *     Prompts the user to enter the name of the announcement,
     *     and then the text of the announcement
     * </p>
     * @return the created announcement
     * @author Benjamin Xu (bfx5005@psu.edu
     */
    public static Announcement createAnnouncement() {
        // TODO 01 - [console_view.AnnouncementView.createAnnouncement] - Prompt user for name and text; create Announcement
        String name = readNonBlankStringFromKeyboard("Name of announcement");
        String text = readNonBlankStringFromKeyboard("Enter text of the announcement");
        Announcement announcement = new Announcement(name,text);

        return announcement;
    }
}
