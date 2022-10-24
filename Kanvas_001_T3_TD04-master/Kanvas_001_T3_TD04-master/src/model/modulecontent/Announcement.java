package model.modulecontent;

import java.time.LocalDateTime;

public class Announcement implements IContent {
    private final String topic;
    private final String text;
    private LocalDateTime publishDateTime;

    public Announcement(String topic, String text) {
        this.topic = topic;
        this.text = text;
    }

    public String getTopic() {
        return topic;
    }

    public String getText() {
        return text;
    }

    @Override
    public String getShortDescription() {
        return topic;
    }

    @Override
    public String getContentType() {
        return "Announcement";
    }
}
