package model;

import model.modulecontent.Announcement;
import model.modulecontent.Assignment;
import model.modulecontent.Discussion;
import model.modulecontent.Quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Section {
    private Teacher teacher;

    private final List<Student> students = new ArrayList<>();
    private final List<Module> modules = new ArrayList<>();
    private final List<Discussion> discussions = new ArrayList<>();
    private List<Announcement> announcements = new ArrayList<>();
    private final List<Assignment> assignments = new ArrayList<>();
    private final List<Quiz> quizzes = new ArrayList<>();

    public void addStudent(Student student) {
        if (students.contains(student)) {
            throw new IllegalArgumentException(String.format("Student '%s' already in section", student.toString()));
        }
        students.add(student);
    }

    public void addStudents(List<Student> students) {
        this.students.addAll(students);
    }

    public void dropStudent(Student student) {
        students.remove(student);
    }

    public int studentCount() {
        return students.size();
    }

    public Student findStudent(String psuLogin) {
        for (Student s : students) {
            if (s.getLogin().equals(psuLogin)) {
                return s;
            }
        }
        return null;
    }

    public void addModule(Module module) {
        modules.add(module);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Iterable<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public boolean isEnrolled(String psuLogin) {
        return (findStudent(psuLogin) != null);
    }

    public Iterable<Announcement> getAnnouncements() {
        return Collections.unmodifiableList(announcements);
    }

    public void setAnnouncements(List<Announcement> announcements) {
        this.announcements = announcements;
    }

    public Iterable<Assignment> getAssignments() {
        return Collections.unmodifiableList(assignments);
    }

    public Iterable<Quiz> getQuizzes() {
        return Collections.unmodifiableList(quizzes);
    }

    public void addAssignment(Assignment assignment) {
        assignments.add(assignment);
    }

    public void addQuiz(Quiz quiz) {
        quizzes.add(quiz);
    }

    public void addAnnouncement(Announcement announcement) {
        announcements.add(announcement);
    }

    public void deleteAnnouncement(Announcement announcement) {
        announcements.remove(announcement);
    }

    public void deleteAssignment(Assignment assignment) {
        assignments.remove(assignment);
    }

    public void deleteQuiz(Quiz quiz) {
        quizzes.remove(quiz);
    }

    public Iterable<Module> getModules() {
        return Collections.unmodifiableList(modules);
    }

    public void deleteStudent(Student student) {
        students.remove(student);
    }

    public void deleteModule(Module module) {
        modules.remove(module);
    }

    public Iterable<Discussion> getDiscussions() {
        return Collections.unmodifiableList(discussions);
    }

    public void deleteDiscussion(Discussion discussion) {
        discussions.remove(discussion);
    }

    public void addDiscussion(Discussion discussion) {
        discussions.add(discussion);
    }
}
