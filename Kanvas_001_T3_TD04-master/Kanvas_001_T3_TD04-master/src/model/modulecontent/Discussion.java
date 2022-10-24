package model.modulecontent;

import model.DiscussionReply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Discussion implements IContent {
    private String title;
    private String text;
    private final List<DiscussionReply> replies = new ArrayList<>();

    private Discussion() {
    }

    public Discussion(String title) {
        this.title = title;
    }

    public void addReply(DiscussionReply reply) {
        replies.add(reply);
    }

    public Iterable<DiscussionReply> getReplies() {
        return Collections.unmodifiableList(replies);
    }

    @Override
    public String getShortDescription() {
        return title;
    }

    @Override
    public String getContentType() {
        return "Discussion";
    }


    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void deleteDiscussionReply(DiscussionReply discussionReply) {
        replies.remove(discussionReply);
    }
}
