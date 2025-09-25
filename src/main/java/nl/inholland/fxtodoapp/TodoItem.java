package nl.inholland.fxtodoapp;

import java.io.Serial;
import java.io.Serializable;

public class TodoItem implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String description;
    private boolean completed;

    public TodoItem(String description, boolean completed) {
        this.description = description;
        this.completed = completed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
