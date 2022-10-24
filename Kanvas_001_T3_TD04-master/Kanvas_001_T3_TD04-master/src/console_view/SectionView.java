package console_view;

import edu.psu.consolemenu.Menu;
import edu.psu.consolemenu.MenuAction;
import edu.psu.consolemenu.MenuChoice;
import edu.psu.consolemenu.MenuDisplay;
import model.Module;
import model.Section;
import model.Student;
import model.modulecontent.Announcement;
import model.modulecontent.Assignment;
import model.modulecontent.Discussion;
import model.modulecontent.Quiz;

public class SectionView {
    private final Section section;

    public SectionView(Section section) {
        this.section = section;
    }

    /*
     * A menu that we can reuse, that contains commonly-used choices
     */
    private final Menu mnMaint = new Menu("Maintenance");
    private final MenuChoice mcList = mnMaint.addMenuChoice("List");
    private final MenuChoice mcCreate = mnMaint.addMenuChoice("Create");
    private final MenuChoice mcDelete = mnMaint.addMenuChoice("Delete");
    private final MenuChoice mcQuit = mnMaint.getMenuChoiceQuit();
    private final MenuDisplay mdMaint = new MenuDisplay(mnMaint);

    public Student chooseStudent(String title) {
        Menu menu = new Menu(title);

        for (Student student : section.getStudents()) {
            MenuChoice choice = new MenuChoice(student.toString());
            choice.setObject(student);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Student) choice.getObject();
        }
    }
    public final MenuAction handleStudents = new MenuAction() {
        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Student Maintenance");
            mcList.setMenuAction(listStudents);
            mcCreate.setMenuAction(createStudent);
            mcDelete.setMenuAction(deleteStudent);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private final MenuAction listStudents = new MenuAction() {
        @Override
        public void execute() {
            Student student;
            do {
                student = chooseStudent("Students");
                if (student != null) {
                    StudentView.displayDetail(student);
                }
            } while (student != null);
        }
    };
    private final MenuAction createStudent = new MenuAction() {
        @Override
        public void execute() {
            Student Student = StudentView.createStudent();
            section.addStudent(Student);
        }
    };
    private final MenuAction deleteStudent = new MenuAction() {
        @Override
        public void execute() {
            Student student;
            do {
                student = chooseStudent("Delete Student");
                if (student != null) {
                    section.deleteStudent(student);
                }
            } while (student != null);
        }
    };

    private Module chooseModule(String title) {
        Menu menu = new Menu(title);

        for (Module module : section.getModules()) {
            MenuChoice choice = new MenuChoice(module.getName());
            choice.setObject(module);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Module) choice.getObject();
        }
    }
    public final MenuAction handleModules = new MenuAction() {
        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Module Maintenance");
            mcList.setMenuAction(listModules);
            mcCreate.setMenuAction(createModule);
            mcDelete.setMenuAction(deleteModule);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private final MenuAction listModules = new MenuAction() {
        @Override
        public void execute() {
            Module Module;
            do {
                Module = chooseModule("Modules");
                if (Module != null) {
                    ModuleView.display(Module);
                }
            } while (Module != null);
        }
    };
    private final MenuAction createModule = new MenuAction() {
        @Override
        public void execute() {
            Module Module = ModuleView.createModule(section);
            section.addModule(Module);
        }
    };
    private final MenuAction deleteModule = new MenuAction() {

        private Student chooseStudent(String title) {
            Menu menu = new Menu(title);

            for (Student student : section.getStudents()) {
                MenuChoice choice = new MenuChoice(student.toString());
                choice.setObject(student);
                menu.addMenuChoice(choice);
            }

            MenuDisplay display = new MenuDisplay(menu);

            MenuChoice choice = display.displayAndChoose();
            if (choice == menu.getMenuChoiceQuit()) {
                return null;
            } else {
                return (Student) choice.getObject();
            }
        }
        public MenuAction handleStudents = new MenuAction() {
            @Override
            public void execute() {
                mdMaint.getMenu().setTitle("Student Maintenance");
                mcList.setMenuAction(listStudents);
                mcCreate.setMenuAction(createStudent);
                mcDelete.setMenuAction(deleteStudent);
                while (mdMaint.displayAndChoose() != mcQuit) ;
            }
        };
        private final MenuAction listStudents = new MenuAction() {
            @Override
            public void execute() {
                Student student;
                do {
                    student = chooseStudent("Students");
                    if (student != null) {
                        StudentView.displayDetail(student);
                    }
                } while (student != null);
            }
        };
        private final MenuAction createStudent = new MenuAction() {
            @Override
            public void execute() {
                Student Student = StudentView.createStudent();
                section.addStudent(Student);
            }
        };
        private final MenuAction deleteStudent = new MenuAction() {
            @Override
            public void execute() {
                Student student;
                do {
                    student = chooseStudent("Delete Student");
                    if (student != null) {
                        section.deleteStudent(student);
                    }
                } while (student != null);
            }
        };

        @Override
        public void execute() {
            Module module;
            do {
                module = chooseModule("Delete Module");
                if (module != null) {
                    section.deleteModule(module);
                }
            } while (module != null);
        }
    };

    private Discussion chooseDiscussion(String title) {
        Menu menu = new Menu(title);

        for (Discussion discussion : section.getDiscussions()) {
            MenuChoice choice = new MenuChoice(discussion.getShortDescription());
            choice.setObject(discussion);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Discussion) choice.getObject();
        }
    }
    public final MenuAction handleDiscussions = new MenuAction() {
        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Discussion Maintenance");
            mcList.setMenuAction(listDiscussions);
            mcCreate.setMenuAction(createDiscussion);
            mcDelete.setMenuAction(deleteDiscussion);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private final MenuAction listDiscussions = new MenuAction() {
        @Override
        public void execute() {
            Discussion discussion;
            do {
                discussion = chooseDiscussion("Discussions");
                if (discussion != null) {
                    DiscussionView view = new DiscussionView(section, discussion);
                    view.display();
                }
            } while (discussion != null);
        }

    };
    private final MenuAction createDiscussion = new MenuAction() {
        @Override
        public void execute() {
            Discussion Discussion = DiscussionView.createDiscussion();
            section.addDiscussion(Discussion);
        }
    };
    private final MenuAction deleteDiscussion = new MenuAction() {
        @Override
        public void execute() {
            Discussion discussion;
            do {
                discussion = chooseDiscussion("Delete Discussion");
                if (discussion != null) {
                    section.deleteDiscussion(discussion);
                }
            } while (discussion != null);
        }
    };

    private Announcement chooseAnnouncement(String title) {
        Menu menu = new Menu(title);

        for (Announcement announcement : section.getAnnouncements()) {
            MenuChoice choice = new MenuChoice(announcement.getTopic());
            choice.setObject(announcement);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Announcement) choice.getObject();
        }
    }
    public final MenuAction handleAnnouncements = new MenuAction() {
        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Announcement Maintenance");
            mcList.setMenuAction(listAnnouncements);
            mcCreate.setMenuAction(createAnnouncement);
            mcDelete.setMenuAction(deleteAnnouncement);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private final MenuAction listAnnouncements = new MenuAction() {
        @Override
        public void execute() {
            Announcement announcement;
            do {
                announcement = chooseAnnouncement("Announcements");
                if (announcement != null) {
                    AnnouncementView.display(announcement);
                }
            } while (announcement != null);
        }
    };
    private final MenuAction createAnnouncement = new MenuAction() {
        @Override
        public void execute() {
            Announcement announcement = AnnouncementView.createAnnouncement();
            section.addAnnouncement(announcement);
        }
    };
    private final MenuAction deleteAnnouncement = new MenuAction() {
        @Override
        public void execute() {
            Announcement announcement;
            do {
                announcement = chooseAnnouncement("Delete Announcement");
                if (announcement != null) {
                    section.deleteAnnouncement(announcement);
                }
            } while (announcement != null);
        }
    };

    private Assignment chooseAssignment(String title) {
        Menu menu = new Menu(title);

        for (Assignment assignment : section.getAssignments()) {
            MenuChoice choice = new MenuChoice(assignment.getName());
            choice.setObject(assignment);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Assignment) choice.getObject();
        }
    }
    public final MenuAction handleAssignments = new MenuAction() {

        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Assignment Maintenance");
            mcList.setMenuAction(listAssignments);
            mcCreate.setMenuAction(createAssignment);
            mcDelete.setMenuAction(deleteAssignment);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private final MenuAction listAssignments = new MenuAction() {
        @Override
        public void execute() {
            Assignment assignment;
            do {
                assignment = chooseAssignment("Assignments");
                if (assignment != null) {
                    AssignmentView.display(assignment);
                }
            } while (assignment != null);
        }
    };
    private final MenuAction createAssignment = new MenuAction() {
        @Override
        public void execute() {
            Assignment assignment = AssignmentView.createAssignment();
            section.addAssignment(assignment);
        }
    };
    private final MenuAction deleteAssignment = new MenuAction() {
        @Override
        public void execute() {
            Assignment assignment;
            do {
                assignment = chooseAssignment("Delete Assignments");
                if (assignment != null) {
                    section.deleteAssignment(assignment);
                }
            } while (assignment != null);
        }
    };

    private Quiz chooseQuiz(String title) {
        Menu menu = new Menu(title);

        for (Quiz quiz : section.getQuizzes()) {
            MenuChoice choice = new MenuChoice(quiz.getName());
            choice.setObject(quiz);
            menu.addMenuChoice(choice);
        }

        MenuDisplay display = new MenuDisplay(menu);

        MenuChoice choice = display.displayAndChoose();
        if (choice == menu.getMenuChoiceQuit()) {
            return null;
        } else {
            return (Quiz) choice.getObject();
        }
    }
    public final MenuAction handleQuizzes = new MenuAction() {

        @Override
        public void execute() {
            mdMaint.getMenu().setTitle("Quiz Maintenance");
            mcList.setMenuAction(listQuizzes);
            mcCreate.setMenuAction(createQuiz);
            mcDelete.setMenuAction(deleteQuiz);
            while (mdMaint.displayAndChoose() != mcQuit) ;
        }
    };
    private final MenuAction listQuizzes = new MenuAction() {
        @Override
        public void execute() {
            Quiz quiz;
            do {
                quiz = chooseQuiz("Quizzes");
                if (quiz != null) {
                    QuizView.display(quiz);
                }
            } while (quiz != null);
        }
    };
    private final MenuAction createQuiz = new MenuAction() {
        @Override
        public void execute() {
            Quiz quiz = QuizView.createQuiz();
            section.addQuiz(quiz);
        }
    };
    private final MenuAction deleteQuiz = new MenuAction() {
        @Override
        public void execute() {
            Quiz quiz;
            do {
                quiz = chooseQuiz("Delete Quiz");
                if (quiz != null) {
                    section.deleteQuiz(quiz);
                }
            } while (quiz != null);
        }
    };
}
