package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;

public class MaintMenu {
    public final Menu menu = new Menu("");
    public final MenuChoice mcList = menu.addMenuChoice("List");
    public final MenuChoice mcCreate = menu.addMenuChoice("Create");
    public final MenuChoice mcDelete = menu.addMenuChoice("Delete");
    public final MenuChoice mcQuit = menu.getMenuChoiceQuit();
    public final MenuDisplay display = new MenuDisplay(menu);

    public MaintMenu(String title) {
        menu.setTitle(title);
    }
}
