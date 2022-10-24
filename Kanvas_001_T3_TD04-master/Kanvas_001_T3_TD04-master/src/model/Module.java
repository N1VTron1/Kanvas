package model;

import model.modulecontent.IContent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Module {
    boolean isPublished = false;
    final List<IContent> contents = new ArrayList<>();
    private final String name;

    public Module(String name) {
        this.name = name;
    }

    public void addContent(IContent content) {
        contents.add(content);
    }

    public String getName() {
        return name;
    }

    public Iterable<IContent> getContents() {
        return Collections.unmodifiableList(contents);
    }
}